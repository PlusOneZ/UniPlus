package cn.edu.tongji.uniplus.user.repository;

import cn.edu.tongji.uniplus.user.model.uniplusUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface uniplusUserRepository extends JpaRepository<uniplusUser, Long> {
    public uniplusUser findByUserIdAndUserPassword(Long userId, String userPassword);

    public uniplusUser findByUserId(Long userId);

    // 测试用的根据用户ID修改用户名的接口
    @Modifying
    @Query("UPDATE uniplusUser uniUser SET uniUser.userNickName = :userNickName WHERE uniUser.userNickName = :userId")
    void updateUniplusUserName(@Param("userNickName") String userNickName, @Param("userId") Long userId);
}
