package cn.edu.tongji.uniplus.user.controller;

import cn.dev33.satoken.sso.SaSsoUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.edu.tongji.uniplus.user.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * SsoLoginController 前后端分离下尝试使用的登陆模块。
 *
 * @author 卓正一
 * @since 2021/11/24 7:53 PM
 */
@RestController
@RequestMapping("sso/login")
public class SsoLoginController {

    @Resource
    LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public SaResult userSsoLogin(
            @RequestParam Integer phoneCode,
            @RequestParam String phone,
            @RequestParam String password
    ) {
        switch (loginService.userLogin(phoneCode, phone, password)) {
            case IncorrectPassword:
                return SaResult.code(400).setData("Incorrect password");
            case Success:
                StpUtil.login(loginService.getUserIdByPhone(phoneCode, phone));
                return SaResult.data("success");
            case NoUser:
                return SaResult.code(404).setData("No such user");
        }
        return SaResult.code(500).setData("unknown state");
    }

    @GetMapping("/isLogin")
    public Object isLogin() {
        return SaResult.data(StpUtil.isLogin());
    }

    @GetMapping("/getSsoAuthUrl")
    public SaResult getSsoAuthUrl(String clientLoginUrl) {
        String serverAuthUrl = SaSsoUtil.buildServerAuthUrl(clientLoginUrl, "");
        return SaResult.data(serverAuthUrl);
    }


}
