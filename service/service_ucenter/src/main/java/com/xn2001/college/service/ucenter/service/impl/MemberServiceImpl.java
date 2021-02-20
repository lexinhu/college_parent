package com.xn2001.college.service.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xn2001.college.common.base.result.ResultCodeEnum;
import com.xn2001.college.common.base.util.FormUtils;
import com.xn2001.college.common.base.util.JwtInfo;
import com.xn2001.college.common.base.util.JwtUtils;
import com.xn2001.college.common.base.util.MD5;
import com.xn2001.college.service.base.dto.MemberDto;
import com.xn2001.college.service.base.exception.CollegeException;
import com.xn2001.college.service.ucenter.entity.Member;
import com.xn2001.college.service.ucenter.entity.vo.LoginVo;
import com.xn2001.college.service.ucenter.entity.vo.RegisterVo;
import com.xn2001.college.service.ucenter.mapper.MemberMapper;
import com.xn2001.college.service.ucenter.service.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-07-29
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 会员注册
     *
     * @param registerVo
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(RegisterVo registerVo) {

        String nickname = registerVo.getNickname();
        String mobile = registerVo.getMobile();
        String email = registerVo.getEmail();
        String password = registerVo.getPassword();
        String code = registerVo.getCode();

        //手机号和邮箱不能同时为空
        if (StringUtils.isEmpty(mobile) && StringUtils.isEmpty(email)) {
            throw new CollegeException(ResultCodeEnum.PARAM_ERROR);
        }

        //优先校验手机，没有手机则校验邮箱
        //注意: 这里需要使用 '|' 要两边都能检测到
        if (!StringUtils.isEmpty(mobile) | FormUtils.isMobile(mobile)) {
            //校验验证码
            String checkCode = redisTemplate.opsForValue().get(mobile);
            if (!code.equals(checkCode)) {
                throw new CollegeException(ResultCodeEnum.CODE_ERROR);
            }
        } else if (!StringUtils.isEmpty(email) | FormUtils.isMobile(email)) {
            //校验验证码
            String checkCode = redisTemplate.opsForValue().get(email);
            if (!code.equals(checkCode)) {
                throw new CollegeException(ResultCodeEnum.CODE_ERROR);
            }
        }

        //是否被注册的条件
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(mobile)){
            queryWrapper.lambda().eq(Member::getMobile,mobile);
        }
        if (!StringUtils.isEmpty(email)){
            queryWrapper.lambda().or().eq(Member::getEmail,email);
        }
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new CollegeException(ResultCodeEnum.REGISTER_USERINFO_ERROR);
        }

        //注册
        Member member = new Member();
        member.setNickname(nickname);
        member.setMobile(mobile);
        member.setEmail(email);
        member.setPassword(MD5.encrypt(password));
        member.setDisabled(false);
        //默认头像
        member.setAvatar("https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205056.jpg");
        baseMapper.insert(member);
    }

    @Override
    public String login(LoginVo loginVo) {

        String userInfo = loginVo.getUserInfo();
        String password = loginVo.getPassword();

        //使用邮箱或者手机号登录
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Member::getMobile, userInfo).or().eq(Member::getEmail, userInfo);
        System.out.println(userInfo);
        Member member = baseMapper.selectOne(queryWrapper);

        if (member == null) {
            throw new CollegeException(ResultCodeEnum.LOGIN_ERROR);
        }

        //校验密码
        if (!MD5.encrypt(password).equals(member.getPassword())) {
            throw new CollegeException(ResultCodeEnum.LOGIN_ERROR);
        }

        //检验用户是否被禁用
        if (member.getDisabled()) {
            throw new CollegeException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }

        JwtInfo jwtInfo = new JwtInfo();
        jwtInfo.setId(member.getId());
        jwtInfo.setNickname(member.getNickname());
        jwtInfo.setAvatar(member.getAvatar());
        String jwtToken = JwtUtils.getJwtToken(jwtInfo, 1800);

        return jwtToken;
    }

    @Override
    public Member getByOpenid(String openid) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public MemberDto getMemberDtoByMemberId(String memberId) {
        Member member = baseMapper.selectById(memberId);
        MemberDto memberDto = new MemberDto();
        BeanUtils.copyProperties(member, memberDto);
        return memberDto;
    }

    @Override
    public Integer countRegisterNum(String day) {
        return baseMapper.selectRegisterNumByDay(day);
    }
}
