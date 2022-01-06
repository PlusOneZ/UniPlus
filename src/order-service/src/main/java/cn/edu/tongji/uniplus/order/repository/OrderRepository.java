package cn.edu.tongji.uniplus.order.repository;

import cn.edu.tongji.uniplus.order.model.Order;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findAllByBuyerIdAndSellerIdAndStatusAndCreatedTimeBeforeAndCreatedTimeAfter(
            Long buyerId,
            Long sellerId,
            Integer status,
            Date startTime,
            Date endTime
    );

}
