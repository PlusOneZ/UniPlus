package cn.edu.tongji.uniplus.carpooling.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.edu.tongji.uniplus.carpooling.model.OrderGroupEntity;
import cn.edu.tongji.uniplus.carpooling.model.OrderMemberEntity;
import cn.edu.tongji.uniplus.carpooling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description TODO
 * @createTime 2021年12月29日 23:23:00
 */
@RestController
@RequestMapping("/api/v1/carpooling/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/newOrder")
    public SaResult addOrder(@RequestBody OrderGroupEntity orderEntity) throws IOException {
        Object stpLoginID =  StpUtil.getLoginIdDefaultNull();
        if(stpLoginID != null) {
            Long userId = Long.parseLong((String) stpLoginID);
            if(orderService.createOrder(orderEntity.getOrderName(),userId,orderEntity.getPrice())){
                return SaResult.ok();
            }
            return SaResult.code(400).setData("错误");
        }
        else{
            return SaResult.code(400).setData("未登录");
        }
    }

    @PostMapping("/invite")
    public SaResult addOrder(@RequestBody OrderMemberEntity orderMemberEntity) throws IOException {
        Object stpLoginID =  StpUtil.getLoginIdDefaultNull();
        if(stpLoginID != null) {
            Long userId = Long.parseLong((String) stpLoginID);
            orderService.invite2Order(orderMemberEntity.getOrderId(),orderMemberEntity.getMemberId());
            return SaResult.ok();
        }
        else{
            return SaResult.code(400).setData("未登录");
        }
    }

    @GetMapping("/getInfo/{destination}")
    public SaResult addOrder(@PathVariable String destination){
        return SaResult.ok().setData(orderService.getOrders(destination));
    }

    @DeleteMapping("/delete")
    public SaResult deleteOrder(@RequestParam String order_id) throws IOException {
        Object stpLoginID =  StpUtil.getLoginIdDefaultNull();
        if(stpLoginID != null) {
            Long userId = Long.parseLong((String) stpLoginID);
            orderService.quiteOrder(order_id);
            return SaResult.ok();
        }
        else{
            return SaResult.code(400).setData("未登录");
        }
    }
}
