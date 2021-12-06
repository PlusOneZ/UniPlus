package cn.edu.tongji.uniplus.chatting.service;

import cn.edu.tongji.uniplus.chatting.enums.LoginStatus;
import cn.edu.tongji.uniplus.chatting.model.UserEntity;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName LoginService.java
 * @Description TODO
 * @createTime 2021年12月06日 13:58:00
 */
public interface LoginService {
    public LoginStatus userLogin(String email,String password);
}
