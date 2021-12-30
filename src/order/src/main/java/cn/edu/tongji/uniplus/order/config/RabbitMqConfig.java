package cn.edu.tongji.uniplus.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMqConfig
 *
 * @author 卓正一
 * @since 2021/12/1 12:25 AM
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queuePlaceOrder() {
        return new Queue("order.expire");
    }

    @Bean
    public DirectExchange orderPlacementDirectExchange() {
        return new DirectExchange("orderExpireDirect", true, false);
    }

    @Bean
    Binding bindingExchangeUserGoodInformation() {
        String ORDER_PLACE_ROUTING_KEY = "orderExpireRouting";
        return BindingBuilder.bind(queuePlaceOrder()).to(orderPlacementDirectExchange()).with(ORDER_PLACE_ROUTING_KEY);
    }

}
