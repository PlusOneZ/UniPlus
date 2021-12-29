package cn.edu.tongji.uniplus.carpooling.repository;

import cn.edu.tongji.uniplus.carpooling.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderRepository.java
 * @Description TODO
 * @createTime 2021年12月29日 22:15:00
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,String> {
    OrderEntity findOrderEntityByOrderId(String orderId);
}
