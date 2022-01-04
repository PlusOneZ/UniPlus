package cn.edu.tongji.uniplus.notificationcenter.repository;

import cn.edu.tongji.uniplus.notificationcenter.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findAllById(String id);

}
