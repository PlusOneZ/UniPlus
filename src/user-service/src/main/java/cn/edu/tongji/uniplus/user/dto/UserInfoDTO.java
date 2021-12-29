package cn.edu.tongji.uniplus.user.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserInfoDTO {
    private long userId;
    private String userSchoolId;
    private String userNickName;
    private String userPhone;
    private int userPhoneCode;
    private Timestamp userCreateTime;
    private int userGender;
    private String userAvatarLink;
    private int userRole;
    private String userRealName;
}
