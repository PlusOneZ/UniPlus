package cn.edu.tongji.uniplus.nearby_place.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * UserReceiver
 *
 * @author 卓正一
 * @since 2021/12/1 3:48 PM
 */

@Component
@RabbitListener(queues = "UserRegisterQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(Map user) {
        System.out.println("收到来自队列的用户！");
        System.out.println(user);
    }
}
