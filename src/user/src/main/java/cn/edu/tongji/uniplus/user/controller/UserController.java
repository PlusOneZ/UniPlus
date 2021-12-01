package cn.edu.tongji.uniplus.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.service.LoginService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Resource
    RabbitTemplate rabbitTemplate;
    /*
        @模块：登录
        @作用：可以让用户登录，让sa-token框架认证用户的登录从而允许用户进行进一步的操作
        @参数：用户的账号、密码
        @主要的情况：-1代表该账号不存在，404代表账号或密码错误，200代表登陆成功（这些都是Service层写出来的内容）
     */
    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestParam("userId") Long userId, @RequestParam("userPassword") String userPassword) {
        UserEntity loginUser = new UserEntity();
        loginUser.setUserId(userId);
        loginUser.setUserPassword(DigestUtils.md5DigestAsHex(userPassword.getBytes()));
        Integer loginStatus = loginService.userLogin(loginUser);
        if (loginStatus == -1)
            return ResponseEntity.ok("账号不存在！");
        else if (loginStatus == 404)
            return ResponseEntity.ok("账号或密码输入错误，请重新输入");
        else if (loginStatus == 200) {
            StpUtil.login(userId);
            return ResponseEntity.ok("登陆成功,当前登陆账号为: " + userId.toString());
        }
        return ResponseEntity.notFound().build();
    }

    /*
    @模块：注册
    @作用：可以让用户注册，把数据加入到系统里
    @参数：用户的用户名、密码、性别。最终会返回系统为用户生成的账号
    */
    @GetMapping("/register")
    public ResponseEntity<String> userRegister(@RequestParam("userNickName") String userNickName,
                                               @RequestParam("userPassword") String userPassword,
                                               @RequestParam("userGender") Integer userGender) {

        UserEntity uniplusUser = new UserEntity();//创建一个空用户，然后设置参数里请求的信息
        uniplusUser.setUserNickName(userNickName);
        uniplusUser.setUserPassword(DigestUtils.md5DigestAsHex(userPassword.getBytes()));
        uniplusUser.setUserGender(userGender);
        //调用服务层里的注册函数就可以啦

        rabbitTemplate.convertAndSend("UserDirectExchange", "UserDirectRouting", uniplusUser);
//        loginService.userRegister(uniplusUser);
        return ResponseEntity.ok("您的账号是: " + 11);
    }

    /*
    @模块：登出
    @作用：可以让用户注销，sa-token在后端清楚相关信息
    */
    @GetMapping("/logout")
    public ResponseEntity<String> userLogout() {
        StpUtil.logout();
        return ResponseEntity.ok("注销成功");
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkLogin() {
        return ResponseEntity.ok("当前登陆状态:" + StpUtil.isLogin() + " 登陆账号:" + StpUtil.getLoginIdDefaultNull());
    }

    @GetMapping("/user_token")
    public ResponseEntity<String> getToken() {
        return ResponseEntity.ok(StpUtil.getTokenValue() == null ? "您尚未登录" : StpUtil.getTokenValue());
    }

    @GetMapping("/permission/{name}")
    public ResponseEntity<String> getPermission(@PathVariable("name") String name) {
        if (StpUtil.hasPermission(name))
            return ResponseEntity.ok("您有该权限");
        else
            return ResponseEntity.ok("您没有该权限");
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<String> getRole(@PathVariable("name") String name) {
        if (StpUtil.hasRole(name))
            return ResponseEntity.ok("您是用户");
        else
            return ResponseEntity.ok("您不是用户");
    }

    @GetMapping("/token_user")        // 通过token获得id，如果没有就返回空值让前端去具体处理
    public ResponseEntity<String> getUserByToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(StpUtil.getLoginIdByToken(token) == null ? "您尚未登录" : StpUtil.getLoginIdByToken(token).toString());
    }
}
