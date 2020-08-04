package com.xn2001.college.service.trade.controller.api;


import com.xn2001.college.common.base.result.R;
import com.xn2001.college.common.base.util.JwtInfo;
import com.xn2001.college.common.base.util.JwtUtils;
import com.xn2001.college.service.trade.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author 乐心湖
 * @since 2020-08-02
 */
@RestController
@RequestMapping("/api/trade/order")
@Api(tags = "网站订单管理")
@CrossOrigin //跨域
@Slf4j
public class ApiOrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("新增订单")
    @PostMapping("auth/save/{courseId}")
    public R save(@PathVariable String courseId, HttpServletRequest request) {

        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        String orderId = orderService.saveOrder(courseId, jwtInfo.getId());
        return R.ok().data("orderId", orderId);
    }
}

