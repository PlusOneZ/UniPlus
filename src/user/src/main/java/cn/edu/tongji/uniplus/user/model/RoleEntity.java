package cn.edu.tongji.uniplus.user.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * RoleEntity
 *
 * @author 卓正一
 * @since 2021/11/24 8:10 PM
 */
@Entity
@Table(name = "uniplus_role", schema = "uniplus_user", catalog = "")
public class RoleEntity {
    private int roleId;
    private String roleName;
    private boolean roleCanPost;
    private boolean roleCanTrade;
    private boolean roleCanPublishGood;
    private boolean roleCanComment;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_can_post")
    public boolean isRoleCanPost() {
        return roleCanPost;
    }

    public void setRoleCanPost(boolean roleCanPost) {
        this.roleCanPost = roleCanPost;
    }

    @Basic
    @Column(name = "role_can_trade")
    public boolean isRoleCanTrade() {
        return roleCanTrade;
    }

    public void setRoleCanTrade(boolean roleCanTrade) {
        this.roleCanTrade = roleCanTrade;
    }

    @Basic
    @Column(name = "role_can_publish_good")
    public boolean isRoleCanPublishGood() {
        return roleCanPublishGood;
    }

    public void setRoleCanPublishGood(boolean roleCanPublishGood) {
        this.roleCanPublishGood = roleCanPublishGood;
    }

    @Basic
    @Column(name = "role_can_comment")
    public boolean isRoleCanComment() {
        return roleCanComment;
    }

    public void setRoleCanComment(boolean roleCanComment) {
        this.roleCanComment = roleCanComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId && roleCanPost == that.roleCanPost && roleCanTrade == that.roleCanTrade && roleCanPublishGood == that.roleCanPublishGood && roleCanComment == that.roleCanComment && Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleCanPost, roleCanTrade, roleCanPublishGood, roleCanComment);
    }
}
