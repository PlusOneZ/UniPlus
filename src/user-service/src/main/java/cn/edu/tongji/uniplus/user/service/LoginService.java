package cn.edu.tongji.uniplus.user.service;

import cn.edu.tongji.uniplus.user.service.impl.LoginServiceImpl;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    LoginStatus checkUserLogin(String phone, String password);

    Long getUserIdByPhone(String phone);

    String getUserPhoneById(Long id);

    /**
     * LoginStatus 用于表征用户登录状态的枚举变量。
     * @author 卓正一
     * @since 2021-11-24 9:09 PM
     */
    enum LoginStatus {
        NoUser, IncorrectPassword, Success
    }
}

// Integer getAdminIdByName(String adminName);

// UserBriefInfoDTO getUserBriefInfoByCustomerId(Long id);

// VerifyCodeToken getVerificationCodeAndToken();

// Boolean checkAdminLogin(String adminName, String password);