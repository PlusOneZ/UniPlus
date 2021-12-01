package cn.edu.tongji.uniplus.user.controller;

import cn.edu.tongji.uniplus.user.service.SignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * SignupController
 *
 * @author 卓正一
 * @since 2021/12/1 4:28 PM
 */
@RestController
@RequestMapping("signup")
public class SignupController {

    @Resource
    SignupService signupService;

    @GetMapping("user")
    public ResponseEntity<Map<String, Long>> userRegister(
            @RequestParam Integer phoneCode,
            @RequestParam String phone,
            @RequestParam String nickName,
            @RequestParam String password,
            @RequestParam(required = false) Integer gender) {
        Long id = signupService.userSignup(phoneCode, phone, password, nickName, gender);

        HashMap<String, Long> ret = new HashMap<String, Long>();
        ret.put("id", id);
        return ResponseEntity.ok(ret);
    }

    @GetMapping("checkPhone")
    public ResponseEntity<HashMap<String, Boolean>> checkCustomerPhoneAvailable(
            @RequestParam Integer phoneCode,
            @RequestParam String phone) {
        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("phoneUnique", signupService.checkPhoneAvailable(phoneCode, phone));
        return ResponseEntity.ok(retMap);
    }

}
