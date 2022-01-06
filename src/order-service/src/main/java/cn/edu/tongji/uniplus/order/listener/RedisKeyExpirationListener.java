package cn.edu.tongji.uniplus.order.listener;

import cn.edu.tongji.uniplus.order.service.OrderService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * use the redis listener to implement control the order expiration...
 *
 * @author : loey
 * @className : RedisKeyExpirationListener
 * @since : 2021-11-26 09:23
 **/

@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Resource
    private OrderService orderService;


    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

        // get the order id to deal with the Timeout situation...
        String orderId = message.toString();
        System.out.println("订单 " + orderId +" 过期！");
        orderService.cancelOrder(orderId);

    }
}