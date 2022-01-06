package cn.edu.tongji.uniplus.notificationcenter.service.impl;

import cn.edu.tongji.uniplus.notificationcenter.model.Notification;
import cn.edu.tongji.uniplus.notificationcenter.model.StatusEnum;
import cn.edu.tongji.uniplus.notificationcenter.payload.NotificationCreationEntity;
import cn.edu.tongji.uniplus.notificationcenter.repository.NotificationRepository;
import cn.edu.tongji.uniplus.notificationcenter.service.NotificationService;
import cn.edu.tongji.uniplus.notificationcenter.util.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * NotificationServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/30 7:19 AM
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Resource
    RedisUtils redisUtils;

    @Resource
    NotificationRepository notificationRepository;

    @Override
    public Notification getNotificationById(String id) {
        Optional<Notification> notificationMono = notificationRepository.findById(id);
        return notificationMono.get();
    }

    @Override
    public void createNotification(NotificationCreationEntity notification) {
        Notification not = new Notification();
        String uuid = UUID.randomUUID().toString();
        not.setId(uuid);
        not.setSenderId(notification.getSenderId());
        not.setReceiverId(notification.getReceiverId());
        not.setContent(notification.getContent());
        not.setTitle(notification.getTitle());
        not.setCreatedTime(new Date());
        not.setReadTime(not.getCreatedTime());

        notificationRepository.save(not);

//        System.out.println("Test mongo");
//        System.out.println(notificationRepository.findById(notification.getId()).get());

        redisUtils.set(uuid, notificationRepository.findById(not.getId()).get(), 1L, TimeUnit.MINUTES);
    }

    @Override
    public Notification updateNotificationStatus(String id, StatusEnum status) {
        return null;
    }

    @Override
    public List<Notification> getNotificationBySenderId(Long id) {
        return null;
    }

    @Override
    public List<Notification> getNotificationByReciverId(Long id) {
        return null;
    }

    @Override
    public List<Notification> getAll() {
        return null;
    }
}
