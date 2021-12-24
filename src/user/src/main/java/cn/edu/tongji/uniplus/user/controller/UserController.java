package cn.edu.tongji.uniplus.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.uniplus.user.dto.UserInfoDTO;
import cn.edu.tongji.uniplus.user.dto.UserSignupDTO;
import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.repository.UserRepository;
import cn.edu.tongji.uniplus.user.service.UserInfoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Resource
    UserInfoService userInfoService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoDTO> getUserInfoByUserId(@PathVariable("userId") Long userId) {
        UserInfoDTO userInfo = new UserInfoDTO();
        UserEntity userInfoEntity = userInfoService.getUserInfo(userId);

        userInfo.setUserId(userInfoEntity.getUserId());
        userInfo.setUserSchoolId(userInfoEntity.getUserSchoolId());
        userInfo.setUserNickName(userInfoEntity.getUserNickName());
        userInfo.setUserPhone(userInfoEntity.getUserPhone());
        userInfo.setUserPhoneCode(userInfoEntity.getUserPhoneCode());
        userInfo.setUserCreateTime(userInfoEntity.getUserCreateTime());
        userInfo.setUserGender(userInfoEntity.getUserGender());
        userInfo.setUserAvatarLink(userInfoEntity.getUserAvatarLink());
        userInfo.setUserRole(userInfoEntity.getUserRole());
        userInfo.setUserRealName(userInfoEntity.getUserRealName());

        return ResponseEntity.status(200).body(userInfo);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserInfoByUserId(@PathVariable("userId") Long userId, @RequestBody UserEntity newUserInfo) {
        if (StpUtil.getLoginId() != userId)
            return ResponseEntity.status(401).body("您无权修改其他用户的信息！");
        userInfoService.updateUserInfo(userId, newUserInfo);
        return ResponseEntity.status(200).body("修改用户信息成功！");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserInfoByUserId(@PathVariable("userId") Long userId) {
        if (StpUtil.getLoginId() != userId)
            return ResponseEntity.status(401).body("您无权修改其他用户的信息！");
        userInfoService.deleteUserInfo(userId);
        return ResponseEntity.status(200).body("用户注销成功！");
    }
}