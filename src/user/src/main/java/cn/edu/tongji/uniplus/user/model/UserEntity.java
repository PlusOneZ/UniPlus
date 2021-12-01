package cn.edu.tongji.uniplus.user.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * UniplusUserEntity
 *
 * @author 卓正一
 * @since 2021/11/24 8:41 PM
 */
@Entity
@Table(name = "uniplus_user", schema = "uniplus_user", catalog = "")
public class UserEntity implements Serializable {
    private long userId;
    private String userSchoolId;
    private String userNickName;
    private String userPassword;
    private String userPhone;
    private int userPhoneCode;
    private Timestamp userCreateTime;
    private int userGender;
    private String userAvatarLink;
    private int userRole;
    private String userRealName;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_school_id")
    public String getUserSchoolId() {
        return userSchoolId;
    }

    public void setUserSchoolId(String userSchoolId) {
        this.userSchoolId = userSchoolId;
    }

    @Basic
    @Column(name = "user_nick_name")
    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_phone_code")
    public int getUserPhoneCode() {
        return userPhoneCode;
    }

    public void setUserPhoneCode(int userPhoneCode) {
        this.userPhoneCode = userPhoneCode;
    }

    @Basic
    @Column(name = "user_create_time")
    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Basic
    @Column(name = "user_gender")
    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    @Basic
    @Column(name = "user_avatar_link")
    public String getUserAvatarLink() {
        return userAvatarLink;
    }

    public void setUserAvatarLink(String userAvatarLink) {
        this.userAvatarLink = userAvatarLink;
    }

    @Basic
    @Column(name = "user_role")
    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "user_real_name")
    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && userPhoneCode == that.userPhoneCode && userGender == that.userGender && userRole == that.userRole && Objects.equals(userSchoolId, that.userSchoolId) && Objects.equals(userNickName, that.userNickName) && Objects.equals(userPassword, that.userPassword) && Objects.equals(userPhone, that.userPhone) && Objects.equals(userCreateTime, that.userCreateTime) && Objects.equals(userAvatarLink, that.userAvatarLink) && Objects.equals(userRealName, that.userRealName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userSchoolId, userNickName, userPassword, userPhone, userPhoneCode, userCreateTime, userGender, userAvatarLink, userRole, userRealName);
    }
}
