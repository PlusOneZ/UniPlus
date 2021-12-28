package cn.edu.tongji.uniplus.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * RabbitMqConfig
 *
 * @author 卓正一
 * @since 2021/12/1 12:25 AM
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue TestDirectQueue() {
        return new Queue("UserRegisterQueue", true);
    }

    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("UserDirectExchange");
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("UserDirectRouting");
    }

}
