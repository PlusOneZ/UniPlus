package cn.edu.tongji.uniplus.good_information.receiver;

import cn.edu.tongji.uniplus.good_information.service.PlaceOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * GoodsStockReceiver
 *
 * @author 卓正一
 * @since 2021/12/30 3:13 PM
 */
@Component
@RabbitListener(queues = "order.expire")
public class GoodsStockReceiver {

    @Resource
    PlaceOrderService placeOrderService;

    @RabbitHandler
    public void process(Map<String, String> order) {
        System.out.println("收到来自队列的失效订单！");
        System.out.println(order);
        placeOrderService.resumeStock(
                Long.parseLong(order.get("goodsId")),
                Integer.parseInt(order.get("purchaseAmount"))
        );
    }
}
