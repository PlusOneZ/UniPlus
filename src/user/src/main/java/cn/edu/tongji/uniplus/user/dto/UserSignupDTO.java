package cn.edu.tongji.uniplus.user.dto;

import lombok.Data;

/**
 * UserSignupDTO
 *
 * @author 卓正一
 * @since 2021/12/10 8:35 PM
 */
@Data
public class UserSignupDTO {
    private Integer phoneCode;
    private String phone;
    private String password;
    private String username;
}
