package cn.edu.tongji.uniplus.user.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//这两个注解可以解决JPA.save方法传null值覆盖数据库预设的bug
@DynamicUpdate
@DynamicInsert
public class uniplusUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    String userSchoolId;
    String userNickName;
    String userPassword;
    String userPhone;
    Integer userPhoneCode;
    String userCreateTime;
    Integer userGender;
    String userAvatarLink;
    Integer userRole;
    String userRealName;

    public uniplusUser() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserSchoolId() {
        return userSchoolId;
    }

    public void setUserSchoolId(String userSchoolId) {
        this.userSchoolId = userSchoolId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserPhoneCode() {
        return userPhoneCode;
    }

    public void setUserPhoneCode(Integer userPhoneCode) {
        this.userPhoneCode = userPhoneCode;
    }

    public String getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserAvatarLink() {
        return userAvatarLink;
    }

    public void setUserAvatarLink(String userAvatarLink) {
        this.userAvatarLink = userAvatarLink;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Override
    public String toString() {
        return "uniplusUser{" +
                "userId=" + userId +
                ", userSchoolId='" + userSchoolId + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPhoneCode=" + userPhoneCode +
                ", userCreateTime='" + userCreateTime + '\'' +
                ", userGender=" + userGender +
                ", userAvatarLink='" + userAvatarLink + '\'' +
                ", userRole=" + userRole +
                ", userRealName='" + userRealName + '\'' +
                '}';
    }
}
