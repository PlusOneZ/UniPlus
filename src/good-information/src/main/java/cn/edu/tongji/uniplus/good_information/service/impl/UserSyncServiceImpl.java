package cn.edu.tongji.uniplus.good_information.service.impl;

import cn.edu.tongji.uniplus.good_information.model.GoodUserEntity;
import cn.edu.tongji.uniplus.good_information.repository.GoodUserRepository;
import cn.edu.tongji.uniplus.good_information.service.UserSyncService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    GoodUserRepository userRepository;

    @Override
    public void addUser(Long userId, String nickName) {
        GoodUserEntity user = new GoodUserEntity();
        user.setGoodUserId(userId);
        user.setGoodUserNickname(nickName);

        System.out.println("用户信息： " + user.getGoodUserId() + " " + user.getGoodUserNickname());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<GoodUserEntity> user = userRepository.findById(userId);
        user.ifPresent(nearbyUserEntity -> userRepository.delete(nearbyUserEntity));
    }
}
