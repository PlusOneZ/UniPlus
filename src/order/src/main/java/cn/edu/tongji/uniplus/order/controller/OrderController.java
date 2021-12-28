package cn.edu.tongji.uniplus.order.controller;

import cn.edu.tongji.uniplus.order.model.Order;
import cn.edu.tongji.uniplus.order.repository.OrderRepository;
import cn.edu.tongji.uniplus.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderController
 *
 * @author 卓正一
 * @since 2021/12/26 11:21 AM
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{orderId}")
    public Order getById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("buyer/{id}/orders")
    public List<Order> getByBuyerId(@PathVariable Long id) {
        return orderService.getOrderByBuyerId(id);
    }

    @GetMapping("seller/{id}/orders")
    public List<Order> getBySellerId(@PathVariable Long id) {
        return orderService.getOrderBySellerId(id);
    }


}
