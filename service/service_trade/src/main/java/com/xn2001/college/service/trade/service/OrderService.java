package com.xn2001.college.service.trade.service;

import com.xn2001.college.service.trade.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-08-02
 */
public interface OrderService extends IService<Order> {

    String saveOrder(String courseId, String id);
}
