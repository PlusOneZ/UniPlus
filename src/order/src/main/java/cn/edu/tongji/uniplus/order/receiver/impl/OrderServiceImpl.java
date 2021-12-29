package cn.edu.tongji.uniplus.order.receiver.impl;

import cn.edu.tongji.uniplus.order.model.Order;
import cn.edu.tongji.uniplus.order.model.StatusEnum;
import cn.edu.tongji.uniplus.order.payload.OrderPlacementEntity;
import cn.edu.tongji.uniplus.order.repository.OrderRepository;
import cn.edu.tongji.uniplus.order.service.OrderService;
import cn.edu.tongji.uniplus.order.utils.RedisUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * OrderServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/30 7:19 AM
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    RedisUtils redisUtils;

    @Resource
    OrderRepository orderRepository;

    @Override
    public Order getOrderById(String id) {
        Mono<Order> orderMono = orderRepository.findById(id);
        return orderMono.block();
    }

    @Override
    public void createOrderFromPlacement(OrderPlacementEntity placement) {
        Order order = new Order();
        order.setBuyerId(placement.getBuyerId());
        order.setSellerId(placement.getSellerId());
        order.setGoodsId(placement.getGoodsId());
        order.setGoodsName(placement.getGoodsName());
        order.setPrice(placement.getPrice());
        order.setDiscountAmount(placement.getDiscountAmount());
        order.setCreatedTime(new Date());
        order.setModifiedTime(order.getCreatedTime());
        order.setPhotoUrl(placement.getPhotoUrl());
        order.setAmount(placement.getPurchaseAmount());

        orderRepository.save(order);


    }

    @Override
    public Order updateOrderStatus(String id, StatusEnum status) {
        return null;
    }

    @Override
    public List<Order> getOrderByBuyerId(Long id) {
        return null;
    }

    @Override
    public List<Order> getOrderBySellerId(Long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
