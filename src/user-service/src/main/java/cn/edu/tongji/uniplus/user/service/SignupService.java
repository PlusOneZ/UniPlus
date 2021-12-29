package cn.edu.tongji.uniplus.user.service;

import cn.edu.tongji.uniplus.user.payload.IdVerificationResult;
import org.springframework.stereotype.Service;


/**
 * For Signup
 *
 * @author 卓正一
 * @since 2021-11-23 7:55 PM
 */
@Service
public interface SignupService {

    Boolean checkPhoneAvailable(String phone);

    void changeUserPassword(String phone, String newPassword);

    void changeUserPassword(Long userId, String newPassword);

//    void sendSmsVerificationCode(String phone);


    IdVerificationResult idVerification(String base64img);

    Long userSignup(Integer phoneCode, String phone, String password, String username);

    Long userSignup(Integer phoneCode, String phone, String password, String username, Integer gender);

    void setUserGender(Long customerId, Integer gender);

    Boolean isPhoneValid(String phone);
}

