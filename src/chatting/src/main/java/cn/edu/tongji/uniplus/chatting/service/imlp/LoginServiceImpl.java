package cn.edu.tongji.uniplus.chatting.service.imlp;

import cn.edu.tongji.uniplus.chatting.enums.LoginStatus;
import cn.edu.tongji.uniplus.chatting.model.UserEntity;
import cn.edu.tongji.uniplus.chatting.repository.UserRepository;
import cn.edu.tongji.uniplus.chatting.service.LoginService;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName LoginServiceImpl.java
 * @Description TODO
 * @createTime 2021年12月06日 14:14:00
 */
public class LoginServiceImpl implements LoginService {
    @Resource
    UserRepository userRepository;

    /// TODO:用户名和邮箱皆可登陆
    @Override
    public LoginStatus userLogin(String email, String password) {
        UserEntity userEntity = userRepository.findUserEntityByUserEmail(email);
        if(userEntity == null)
        {
            return LoginStatus.NoUser;
        }
        else if(Objects.equals(userEntity.getPassword(), password)){
            return LoginStatus.Success;
        }
        else{
            return LoginStatus.IncorrectPassword;
        }
    }
}
