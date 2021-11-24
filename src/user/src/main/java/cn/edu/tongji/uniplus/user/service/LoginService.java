package cn.edu.tongji.uniplus.user.service;

import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService {
    @Resource
    private UserRepository userRepository;

    public String userRegister(UserEntity newUser) {
        return "" + userRepository.save(newUser).getUserId();
    }

    public Integer userLogin(UserEntity loginUser) {
        if (userRepository.findByUserId(loginUser.getUserId()) == null) // 没这个账号
            return -1;
            //账号有，但是和密码对不上
        else if (userRepository.findByUserIdAndUserPassword(loginUser.getUserId(), loginUser.getUserPassword()) == null)
            return 404;
            // 都对上了
        else
            return 200;
    }

    /**
     * userLogin 通过电话号码登陆的服务。
     *
     * @author 卓正一
     * @since 2021-11-24 9:08 PM
     */
    public LoginStatus userLogin(String userPhone, String password) {
        Optional<UserEntity> user = userRepository.findByUserPhone(userPhone);
        if (user.isEmpty()) {
            return LoginStatus.NoUser;
        } else {
            if (user.get().getUserPassword().equals(password)) {
                return LoginStatus.Success;
            }
            return LoginStatus.IncorrectPassword;
        }
    }

    /**
     * getUserIdByPhone 用电话获取用户id
     * @author 卓正一
     * @since 2021-11-24 9:08 PM
     */
    public Long getUserIdByPhone(String userPhone) {
        Optional<UserEntity> user = userRepository.findByUserPhone(userPhone);
        if (user.isEmpty()) {
            throw new RuntimeException("User phone not registered");
        } else {
            return user.get().getUserId();
        }
    }

    /**
     * LoginStatus 用于表征用户登录状态的枚举变量。
     * @author 卓正一
     * @since 2021-11-24 9:09 PM
     */
    public enum LoginStatus {
        NoUser, IncorrectPassword, Success
    }
}
