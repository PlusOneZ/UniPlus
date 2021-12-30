package cn.edu.tongji.uniplus.carpooling.repository;

import cn.edu.tongji.uniplus.carpooling.model.UserEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tangshuo
 * @version 1.0.0x
 * @ClassName UserRepository.java
 * @Description TODO
 * @createTime 2021年12月29日 22:49:00
 */
@Repository
@DynamicUpdate
@DynamicInsert
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
