package com.xn2001.college.service.ucenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xn2001.college.service.ucenter.entity.Member;
import com.xn2001.college.service.ucenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-07-29
 */
public interface MemberService extends IService<Member> {
    void register(RegisterVo registerVo);
}
