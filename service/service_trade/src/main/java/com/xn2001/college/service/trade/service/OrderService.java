package com.xn2001.college.service.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xn2001.college.service.trade.entity.Order;

import java.util.List;
import java.util.Map;

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

    Order getByOrderId(String orderId, String id);

    Boolean isBuyByCourseId(String courseId, String memberId);

    List<Order> selectByMemberId(String id);

    boolean removeById(String orderId, String memberId);

    Order getOrderByOrderNo(String orderNo);

    String updateOrderStatus(Map<String, String> map);

    boolean queryPayStatus(String orderNo);
}
