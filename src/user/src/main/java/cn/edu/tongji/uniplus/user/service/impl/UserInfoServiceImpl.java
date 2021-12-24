package cn.edu.tongji.uniplus.user.service.impl;

import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.repository.UserRepository;
import cn.edu.tongji.uniplus.user.service.UserInfoService;
import cn.edu.tongji.uniplus.user.util.JpaUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoService userInfoService;

    @Resource
    UserRepository userRepository;

    @Override
    public UserEntity getUserInfo(Long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public void deleteUserInfo(Long userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    public UserEntity updateUserInfo(Long userId, UserEntity newUserInfo) {
        UserEntity before = userRepository.findByUserId(userId);
        if (newUserInfo != null) {
            JpaUtil.copyNotNullProperties(newUserInfo, before);
            userRepository.save(before);
        }
        return null;
    }
}
