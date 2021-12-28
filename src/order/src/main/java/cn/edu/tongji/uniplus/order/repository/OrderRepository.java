package cn.edu.tongji.uniplus.order.repository;

import cn.edu.tongji.uniplus.order.model.Order;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
    Mono<Order> findByOrderNo(String orderNo);

    Flux<Order> findAllByBuyerIdAndSellerIdAndStatusAndCreatedTimeBeforeAndCreatedTimeAfter(
            Long buyerId,
            Long sellerId,
            Integer status,
            Date startTime,
            Date endTime
    );

}
