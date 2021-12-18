package cn.edu.tongji.uniplus.user.controller;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.sso.SaSsoHandle;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
//import com.ejlchina.okhttps.OkHttps;
import cn.edu.tongji.uniplus.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * SsoClientController 本该是前后端不分离情况下的api
 *
 * @author 卓正一
 * @since 2021/11/24 4:11 PM
 */
@RestController
public class SsoServerController {

    @Resource
    LoginService loginService;

    @RequestMapping("/sso/request")
    public Object ssoRequest() {
        return SaSsoHandle.serverRequest();
    }

    /**
     * 配置SSO相关参数
     */
    @Autowired
    private void configSso(SaTokenConfig cfg) {
        // TODO: Redirect to Login page in frontend
        cfg.sso.setNotLoginView(() -> {
            String msg = "当前会话在SSO-Server端尚未登录，请先访问"
                    + "<a href='/sso/doLogin?name=sa&pwd=123456' target='_blank'> doLogin登录 </a>"
                    + "进行登录之后，刷新页面开始授权";
            return msg;
        });

        // 配置：登录处理函数
        cfg.sso.setDoLoginHandle((name, pwd) -> {
            switch (loginService.checkUserLogin(name, pwd)) {
                case IncorrectPassword:
                    return SaResult.code(400).setData("Incorrect password");
                case Success:
                    StpUtil.login(loginService.getUserIdByPhone(name));
                    return SaResult.data("success");
                case NoUser:
                    return SaResult.code(404).setData("No such user");
            }
            return SaResult.code(500).setData("unknown state");
        });
    }

}
