package cn.edu.tongji.uniplus.good_information.controller;

import cn.edu.tongji.uniplus.good_information.payload.PlaceOrderResult;
import cn.edu.tongji.uniplus.good_information.service.PlaceOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PlaceOrderController
 * 功能是收到下订单请求，首先检查库存并且向订单中心发送消息。
 * @author 卓正一
 * @since 2021/12/30 1:56 AM
 */
@RestController
@RequestMapping("/api/v1/good/order")
public class PlaceOrderController {

    @Resource
    PlaceOrderService placeOrderService;

    @PostMapping("")
    public ResponseEntity<PlaceOrderResult> placeOrder(
            @RequestParam Long goodId,
            @RequestParam Long userId,
            @RequestParam Integer amount
    ) {
        if (placeOrderService.tryPlaceOrder(userId, goodId, amount)) {
            return ResponseEntity.ok(new PlaceOrderResult("success", true));
        } else {
            return ResponseEntity.ok(new PlaceOrderResult("failed", false));
        }
    }

}
