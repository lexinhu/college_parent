package com.xn2001.college.service.ucenter.controller.api;

import com.xn2001.college.common.base.result.R;
import com.xn2001.college.common.base.result.ResultCodeEnum;
import com.xn2001.college.common.base.util.JwtInfo;
import com.xn2001.college.common.base.util.JwtUtils;
import com.xn2001.college.service.base.dto.MemberDto;
import com.xn2001.college.service.base.exception.CollegeException;
import com.xn2001.college.service.ucenter.entity.vo.LoginVo;
import com.xn2001.college.service.ucenter.entity.vo.RegisterVo;
import com.xn2001.college.service.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 乐心湖
 * @date 2020/7/29 19:42
 **/
@Api(tags = "会员管理")
@RestController
@RequestMapping("/api/ucenter/member")
@Slf4j
public class ApiMemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "会员注册")
    @PostMapping("register")
    public R register(@Validated @RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return R.ok();
    }

    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public R login(@RequestBody LoginVo loginVo) {
        String token = memberService.login(loginVo);
        return R.ok().data("token", token);
    }

    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("get-login-info")
    public R getLoginInfo(HttpServletRequest request) {
        try {
            JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
            return R.ok().data("userInfo", jwtInfo);
        } catch (Exception e) {
            log.error("解析用户信息失败，" + e.getMessage());
            throw new CollegeException(ResultCodeEnum.FETCH_USERINFO_ERROR);
        }
    }

    @ApiOperation("根据会员id查询会员信息")
    @GetMapping("inner/get-member-dto/{memberId}")
    public MemberDto getMemberDtoByMemberId(
            @ApiParam(value = "会员ID", required = true)
            @PathVariable String memberId) {
        MemberDto memberDto = memberService.getMemberDtoByMemberId(memberId);
        return memberDto;
    }
}
