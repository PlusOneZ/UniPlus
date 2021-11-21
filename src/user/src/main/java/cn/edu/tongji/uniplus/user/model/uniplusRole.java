package cn.edu.tongji.uniplus.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class uniplusRole {
    @Id
    private Integer roleId;
    private String roleName;
    private boolean roleCanPost;
    private boolean roleCanTrade;
    private boolean roleCanPublishGood;
    private boolean roleCanComment;

    public uniplusRole() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isRoleCanPost() {
        return roleCanPost;
    }

    public void setRoleCanPost(boolean roleCanPost) {
        this.roleCanPost = roleCanPost;
    }

    public boolean isRoleCanTrade() {
        return roleCanTrade;
    }

    public void setRoleCanTrade(boolean roleCanTrade) {
        this.roleCanTrade = roleCanTrade;
    }

    public boolean isRoleCanPublishGood() {
        return roleCanPublishGood;
    }

    public void setRoleCanPublishGood(boolean roleCanPublishGood) {
        this.roleCanPublishGood = roleCanPublishGood;
    }

    public boolean isRoleCanComment() {
        return roleCanComment;
    }

    public void setRoleCanComment(boolean roleCanComment) {
        this.roleCanComment = roleCanComment;
    }

    @Override
    public String toString() {
        return "uniplusRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleCanPost=" + roleCanPost +
                ", roleCanTrade=" + roleCanTrade +
                ", roleCanPublishGood=" + roleCanPublishGood +
                ", roleCanComment=" + roleCanComment +
                '}';
    }
}
