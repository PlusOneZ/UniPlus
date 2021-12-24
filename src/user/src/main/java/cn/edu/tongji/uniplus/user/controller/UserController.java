package cn.edu.tongji.uniplus.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/checkLoginStatus")
    public ResponseEntity<String> checkLogin() {
        return ResponseEntity.ok("当前登陆状态:" + StpUtil.isLogin() + " 登陆账号:" + StpUtil.getLoginIdDefaultNull());
    }

    @GetMapping("/user_token")
    public ResponseEntity<String> getToken() {
        return ResponseEntity.ok(StpUtil.getTokenValue() == null ? "您尚未登录" : StpUtil.getTokenValue());
    }

    @GetMapping("/permission/{name}")
    public ResponseEntity<Boolean> getPermission(@PathVariable("name") String name) {
        if (StpUtil.hasPermission(name))
            return ResponseEntity.ok(true);
        else
            return ResponseEntity.ok(false);
    }
}