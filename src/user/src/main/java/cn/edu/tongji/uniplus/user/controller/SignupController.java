package cn.edu.tongji.uniplus.user.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.uniplus.user.dto.UserSignupDTO;
import cn.edu.tongji.uniplus.user.payload.IdVerificationResult;
import cn.edu.tongji.uniplus.user.service.LoginService;
import cn.edu.tongji.uniplus.user.service.SignupService;
import cn.edu.tongji.uniplus.user.service.exception.DataFormatException;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * SignupController
 *
 * @author 卓正一
 * @since 2021/11/23 10:18 PM
 */
@Api(tags = "Signup")
@RestController
@RequestMapping("api/v1/user/signup")
public class SignupController {

    @Resource
    private SignupService signupService;

    @Resource
    private LoginService loginService;

    @ApiOperation("Check Whether the Phone is Available")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK")
            }
    )
    @GetMapping("checkPhone")
    public ResponseEntity<HashMap<String, Boolean>> checkCustomerPhoneAvailable(
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestParam String phoneCode,
            @ApiParam(value = "Phone", defaultValue = "19946254155") @RequestParam String phone) {
        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("phoneUnique", signupService.checkPhoneAvailable(phone));
        return ResponseEntity.ok(retMap);
    }

    @ApiOperation("Change User Password")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 401, message = "Not Logged In")
            }
    )
    @PutMapping("changePassword")
    public ResponseEntity<HashMap<String, Boolean>> changeCustomerPassword(
            @ApiParam(value = "New Password", defaultValue = "13456") @RequestParam(required = true) String newPassword,
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestParam(required = false) String phoneCode,
            @ApiParam(value = "Phone", defaultValue = "19946254155") @RequestParam String phone
    ) {
        if (StpUtil.getLoginId() == null) {
            signupService.changeUserPassword(phone, newPassword);
        }
        Long id = Long.valueOf((String) StpUtil.getLoginId());
        signupService.changeUserPassword(id, newPassword);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("changeState", true);
        return ResponseEntity.ok(retMap);
    }

    @ApiOperation("Customer Signup")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 403, message = "User Already Exist")
            }
    )
    @PostMapping("customer")
    public ResponseEntity<HashMap<String, Object>> customerSignup(
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestBody UserSignupDTO userSignupDTO
    ) {
        if (!signupService.isPhoneValid(userSignupDTO.getPhone())) {
            throw new DataFormatException();
        }
        Long id = signupService.userSignup(userSignupDTO.getPhoneCode(), userSignupDTO.getPhone(), userSignupDTO.getPassword(), userSignupDTO.getUsername());

        HashMap<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("registerState", true);
        retMap.put("customerId", id);
        return ResponseEntity.ok(retMap);
    }

    @PostMapping("verifyResidentId")
    public ResponseEntity<IdVerificationResult> verifyId(@RequestBody Map<String, String> body) {
        if (!body.containsKey("positivePhoto")) {
            throw new DataFormatException();
        }
        String img = body.get("positivePhoto");

        // todo verify img using aliyun service
        return ResponseEntity.ok(signupService.idVerification(img));
    }

}
