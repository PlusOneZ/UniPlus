package cn.edu.tongji.uniplus.nearby_place.service.impl;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.UserRepository;
import cn.edu.tongji.uniplus.nearby_place.service.UserSyncService;
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
    UserRepository userRepository;

    @Override
    public void addUser(Long userId, String nickName) {
        NearbyUserEntity user = new NearbyUserEntity();
        user.setUserId(userId);
        user.setUserNickname(nickName);

        System.out.println("用户信息： " + user.getUserId() + " " + user.getUserNickname());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<NearbyUserEntity> user = userRepository.findById(userId);
        user.ifPresent(nearbyUserEntity -> userRepository.delete(nearbyUserEntity));
    }
}
