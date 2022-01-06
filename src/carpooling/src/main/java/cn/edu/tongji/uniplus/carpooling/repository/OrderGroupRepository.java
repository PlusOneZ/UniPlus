package cn.edu.tongji.uniplus.carpooling.repository;

import cn.edu.tongji.uniplus.carpooling.model.OrderGroupEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderGroupRepository.java
 * @Description TODO
 * @createTime 2021年12月29日 22:15:00
 */
@Repository
@DynamicUpdate
@DynamicInsert
public interface OrderGroupRepository extends JpaRepository<OrderGroupEntity,String> {
    OrderGroupEntity findOrderEntityByOrderId(String orderId);

    @Query("SELECT u FROM OrderGroupEntity u WHERE u.orderName LIKE CONCAT('%',?1,'%')")
    List<OrderGroupEntity> findOrderGroupEntitiesByNameLike(String name);
}
