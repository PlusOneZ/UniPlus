package cn.edu.tongji.uniplus.user.service;

import cn.edu.tongji.uniplus.user.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {
    UserEntity getUserInfo(Long userId); // 获取用户个人信息

    void updateUserInfo(Long userId, UserEntity newUserInfo); //更新用户个人信息

    void deleteUserInfo(Long userId); //用户注销
}
