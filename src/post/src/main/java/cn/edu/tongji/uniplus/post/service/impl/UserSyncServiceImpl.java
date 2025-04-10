package cn.edu.tongji.uniplus.post.service.impl;

import cn.edu.tongji.uniplus.post.model.PostUser;
import cn.edu.tongji.uniplus.post.repository.UserRepository;
import cn.edu.tongji.uniplus.post.service.UserSyncService;
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
        PostUser user = new PostUser();
        user.setPostUserId(userId);
        user.setUserNickName(nickName);

        System.out.println("用户信息： " + user.getPostUserId() + " " + user.getUserNickName());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<PostUser> user = userRepository.findById(userId);
        user.ifPresent(nearbyUserEntity -> userRepository.delete(nearbyUserEntity));
    }
}
