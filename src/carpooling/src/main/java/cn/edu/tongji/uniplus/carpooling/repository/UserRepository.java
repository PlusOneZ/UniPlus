package cn.edu.tongji.uniplus.carpooling.repository;

import cn.edu.tongji.uniplus.carpooling.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description TODO
 * @createTime 2021年12月29日 22:49:00
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
