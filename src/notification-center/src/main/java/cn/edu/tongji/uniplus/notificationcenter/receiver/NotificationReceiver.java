package cn.edu.tongji.uniplus.notificationcenter.receiver;

import cn.edu.tongji.uniplus.notificationcenter.model.Notification;
import cn.edu.tongji.uniplus.notificationcenter.payload.MessageBody;
import cn.edu.tongji.uniplus.notificationcenter.payload.NotificationCreationEntity;
import cn.edu.tongji.uniplus.notificationcenter.service.NotificationService;
import cn.edu.tongji.uniplus.notificationcenter.util.RequestUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * NotificationReceiver
 *
 * @author 卓正一
 * @since 2021/12/30 7:14 AM
 */
@Component
@RabbitListener(queues = "good.order.placement")
public class NotificationReceiver {

    @Resource
    NotificationService notificationService;

    @Resource
    RequestUtil requestUtil;

    @RabbitHandler
    public void process(Map<String, String> notification) throws IOException {
        System.out.println("收到来自队列的订单！");
        NotificationCreationEntity entity = NotificationCreationEntity.toEntity(notification);
        MessageBody messageBody = new MessageBody();
        messageBody.setContent(entity.getContent());
        messageBody.setTitle(entity.getTitle());
        String body = JSON.toJSONString(messageBody);
        requestUtil.sendMessage("https://api.netease.im/nimserver/msg/sendMsg.action",
                entity.getSenderId().toString(),"0",entity.getReceiverId().toString(),"0",
                body);

        notificationService.createNotification(entity);
    }
}
