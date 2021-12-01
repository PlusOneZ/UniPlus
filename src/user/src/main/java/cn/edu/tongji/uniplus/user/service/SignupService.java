package cn.edu.tongji.uniplus.user.service;

import org.springframework.stereotype.Service;

@Service
public interface SignupService {

    Boolean checkPhoneAvailable(String phoneCode, String phone);

    void changeUserPassword(String phoneCode, String phone, String newPassword);

    void changeUserPassword(Long userId, String newPassword);

    // TODO 分割一个发送短信的服务接口
    // TODO 一个身份证照片检验服务

    Long userSignup(String phoneCode, String phone, String password, String username);

    Long userSignup(String phoneCode, String phone, String password, String username, String gender);

    void setUserGender(Long customerId, String gender);

}
