package cn.edu.tongji.uniplus.good_information.configure;

import org.springframework.amqp.core.*;
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
        return new Queue("good.order.placement");
    }

    @Bean
    public DirectExchange orderPlacementDirectExchange() {
        return new DirectExchange("orderPlacementDirect", true, false);
    }

    @Bean
    Binding bindingExchangeUserGoodInformation() {
        String ORDER_PLACE_ROUTING_KEY = "orderPlacementRouting";
        return BindingBuilder.bind(queuePlaceOrder()).to(orderPlacementDirectExchange()).with(ORDER_PLACE_ROUTING_KEY);
    }

}
