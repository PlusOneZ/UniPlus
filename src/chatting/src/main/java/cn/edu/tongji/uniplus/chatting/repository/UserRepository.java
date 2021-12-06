package cn.edu.tongji.uniplus.chatting.repository;

import cn.edu.tongji.uniplus.chatting.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description TODO
 * @createTime 2021年12月06日 13:49:00
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByUserName(String userName);
    UserEntity findUserEntityByUserEmail(String userEmail);
}
