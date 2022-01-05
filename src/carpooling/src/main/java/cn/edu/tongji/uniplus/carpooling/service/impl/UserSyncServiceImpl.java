package cn.edu.tongji.uniplus.carpooling.service.impl;

import cn.edu.tongji.uniplus.carpooling.model.UserEntity;
import cn.edu.tongji.uniplus.carpooling.repository.UserRepository;
import cn.edu.tongji.uniplus.carpooling.service.UserSyncService;
import cn.edu.tongji.uniplus.carpooling.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Optional;

/**
 * UserSyncServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/1 5:49 PM
 */
@Service
public class UserSyncServiceImpl implements UserSyncService {

    @Resource
    UserRepository userRepository;

    @Resource
    RequestUtil requestUtil;

    @Override
    public void addUser(Long userId, String nickName) throws IOException {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        user.setUserName(nickName);
        System.out.println("用户信息： " + user.getUserId() + " " + user.getUserName());
        requestUtil.createAccid("https://api.netease.im/nimserver/user/create.action", userId.toString(), nickName);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        user.ifPresent(nearbyUserEntity -> userRepository.delete(nearbyUserEntity));
    }
}
