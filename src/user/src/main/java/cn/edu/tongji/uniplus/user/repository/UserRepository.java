package cn.edu.tongji.uniplus.user.repository;

import cn.edu.tongji.uniplus.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserIdAndUserPassword(Long userId, String userPassword);

    UserEntity findByUserId(Long userId);

    Optional<UserEntity> findByUserPhone(String phone);

    // 测试用的根据用户ID修改用户名的接口
    @Modifying
    @Query("UPDATE UserEntity uniUser SET uniUser.userNickName = :userNickName WHERE uniUser.userNickName = :userId")
    void updateUniplusUserName(@Param("userNickName") String userNickName, @Param("userId") Long userId);
}
