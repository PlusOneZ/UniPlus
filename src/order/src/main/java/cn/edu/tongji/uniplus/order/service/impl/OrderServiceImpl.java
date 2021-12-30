package cn.edu.tongji.uniplus.order.service.impl;

import cn.edu.tongji.uniplus.order.model.Order;
import cn.edu.tongji.uniplus.order.model.StatusEnum;
import cn.edu.tongji.uniplus.order.payload.OrderPlacementEntity;
import cn.edu.tongji.uniplus.order.repository.OrderRepository;
import cn.edu.tongji.uniplus.order.service.OrderService;
import cn.edu.tongji.uniplus.order.service.exception.OrderNotExistException;
import cn.edu.tongji.uniplus.order.utils.RedisUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    @Resource
    RabbitTemplate rabbitTemplate;

    @Override
    public Order getOrderById(String id) {
        Optional<Order> orderMono = orderRepository.findById(id);
        return orderMono.get();
    }

    @Override
    public void createOrderFromPlacement(OrderPlacementEntity placement) {
        Order order = new Order();
        String uuid = UUID.randomUUID().toString();
        order.setId(uuid);
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

        redisUtils.set(uuid, orderRepository.findById(order.getId()).get(), 1L, TimeUnit.MINUTES);
    }

    @Override
    public void cancelOrder(String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            rabbitTemplate.convertAndSend(
                    "orderExpireDirect",
                    "orderExpireRouting",
                    order.toMap()
            );

            order.setStatus(StatusEnum.REVOKED.getCode());
            orderRepository.save(order);
        } else {
            throw new OrderNotExistException();
        }
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
