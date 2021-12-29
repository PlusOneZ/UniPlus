package cn.edu.tongji.uniplus.order.receiver;

import cn.edu.tongji.uniplus.order.payload.OrderPlacementEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * OrderReceiver
 *
 * @author 卓正一
 * @since 2021/12/30 7:14 AM
 */
@Component
@RabbitListener(queues = "good.order.placement")
public class OrderReceiver {

    @RabbitHandler
    public void process(Map<String, String> order) {
        System.out.println("收到来自队列的订单！");
        OrderPlacementEntity entity = OrderPlacementEntity.toEntity(order);


    }
}
