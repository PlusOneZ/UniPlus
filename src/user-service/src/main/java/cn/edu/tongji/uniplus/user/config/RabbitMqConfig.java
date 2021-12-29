package cn.edu.tongji.uniplus.user.config;

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
    public Queue queueUserGoodInformation() {
        return new Queue("user.fanout.good-info");
    }

    @Bean
    public Queue queueUserNearby() {
        return new Queue("user.fanout.nearby");
    }

    @Bean
    public Queue queueUserPost() {
        return new Queue("user.fanout.post");
    }

    @Bean
    public Queue queueUserPooling() {
        return new Queue("user.fanout.carpooling");
    }

    @Bean
    public FanoutExchange userFanoutExchange() {
        return new FanoutExchange("userFanoutExchange", true, false);
    }

    @Bean
    Binding bindingExchangeUserGoodInformation() {
        return BindingBuilder.bind(queueUserGoodInformation()).to(userFanoutExchange());
    }

    @Bean
    Binding bindingExchangeUserNearby() {
        return BindingBuilder.bind(queueUserNearby()).to(userFanoutExchange());
    }

    @Bean
    Binding bindingExchangeUserPost() {
        return BindingBuilder.bind(queueUserPost()).to(userFanoutExchange());
    }

    @Bean
    Binding bindingExchangeUserChatting() {
        return BindingBuilder.bind(queueUserPooling()).to(userFanoutExchange());
    }
}
