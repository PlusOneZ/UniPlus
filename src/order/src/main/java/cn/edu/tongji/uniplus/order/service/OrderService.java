package cn.edu.tongji.uniplus.order.service;

import cn.edu.tongji.uniplus.order.model.Order;
import cn.edu.tongji.uniplus.order.model.StatusEnum;
import cn.edu.tongji.uniplus.order.payload.OrderPlacementEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order getOrderById(String id);

    void createOrderFromPlacement(OrderPlacementEntity placement);

    Order updateOrderStatus(String id, StatusEnum status);

    List<Order> getOrderByBuyerId(Long id);

    List<Order> getOrderBySellerId(Long id);

    List<Order> getAll();
}
