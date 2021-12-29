package cn.edu.tongji.uniplus.carpooling.repository;

import cn.edu.tongji.uniplus.carpooling.model.OrderMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderMemberRepository.java
 * @Description TODO
 * @createTime 2021年12月29日 23:05:00
 */
@Repository
public interface OrderMemberRepository extends JpaRepository<OrderMemberEntity,Long> {
    List<OrderMemberEntity> findOrderMemberEntitiesByOrderId(String orderId);
}
