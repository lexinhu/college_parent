package com.xn2001.college.service.statistics.feign.fallback;

import com.xn2001.college.common.base.result.R;
import com.xn2001.college.service.statistics.feign.UcenterMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 乐心湖
 * @date 2020/8/5 0:47
 **/
@Service
@Slf4j
public class UcenterMemberServiceFallBack implements UcenterMemberService {
    @Override
    public R countRegisterNum(String day) {
        //错误日志
        log.error("熔断器被执行");
        return R.ok().data("registerNum", 0);
    }
}
