package cn.edu.tongji.uniplus.notificationcenter.service;

import cn.edu.tongji.uniplus.notificationcenter.model.Notification;
import cn.edu.tongji.uniplus.notificationcenter.model.StatusEnum;
import cn.edu.tongji.uniplus.notificationcenter.payload.NotificationCreationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    Notification getNotificationById(String id);

    void createNotification(NotificationCreationEntity entity);

    Notification updateNotificationStatus(String id, StatusEnum status);

    List<Notification> getNotificationBySenderId(Long id);

    List<Notification> getNotificationByReciverId(Long id);

    List<Notification> getAll();
}
