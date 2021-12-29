package cn.edu.tongji.uniplus.user.service.impl;

import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.repository.UserRepository;
import cn.edu.tongji.uniplus.user.service.LoginService;
import cn.edu.tongji.uniplus.user.service.exception.UserNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserRepository userRepository;

    /**
     * userLogin 通过电话号码登陆的服务。
     *
     * @author 卓正一
     * @since 2021-11-24 9:08 PM
     */
    public LoginStatus checkUserLogin(String phone, String password) {
        Optional<UserEntity> user = userRepository.findByUserPhone(phone);
        if (user.isEmpty()) {
            return LoginStatus.NoUser;
        } else {
            if (user.get().getUserPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
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
    @Override
    public Long getUserIdByPhone(String phone) {
        Optional<UserEntity> user = userRepository.findByUserPhone(phone);
        if (user.isEmpty()) {
            throw new UserNotExistException();
        } else {
            return user.get().getUserId();
        }
    }

    @Override
    public String getUserPhoneById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get().getUserPhone();
        } else {
            throw new UserNotExistException();
        }
    }

}
