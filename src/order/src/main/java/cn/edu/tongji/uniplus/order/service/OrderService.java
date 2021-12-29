package cn.edu.tongji.uniplus.order.service;

import cn.edu.tongji.uniplus.order.model.Order;
import cn.edu.tongji.uniplus.order.model.StatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order getOrderById(String id);

    String createOrderForUser(Long buyerId, Double discount);

    Order updateOrderStatus(String id, StatusEnum status);

    List<Order> getOrderByBuyerId(Long id);

    List<Order> getOrderBySellerId(Long id);

    List<Order> getOrderByUserId(Long id);

    List<Order> getAll();
}
