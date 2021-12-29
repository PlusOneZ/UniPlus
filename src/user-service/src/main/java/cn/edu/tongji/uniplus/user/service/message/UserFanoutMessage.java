package cn.edu.tongji.uniplus.user.service.message;

import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.payload.UserForQueue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserFanoutMessage
 *
 * @author 卓正一
 * @since 2021/12/29 8:08 PM
 */
@Service
public class UserFanoutMessage {

    @Resource
    RabbitTemplate rabbitTemplate;

    public void sendUserToFanoutQueue(UserEntity user) {
        UserForQueue forQueue = new UserForQueue(user.getUserId(), user.getUserNickName());
        rabbitTemplate.convertAndSend("userFanoutExchange", null,forQueue.toMap());
    }

}
