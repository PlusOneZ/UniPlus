package cn.edu.tongji.uniplus.chatting.service;

import cn.edu.tongji.uniplus.chatting.enums.SignupStatus;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName SignupService.java
 * @Description TODO
 * @createTime 2021年12月06日 13:58:00
 */
public interface SignupService {
    public SignupStatus userSignup(String userName, String email, String password,String face_image,String nickname);
}
