package cn.edu.tongji.uniplus.good_information.model;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "good_user", schema = "uniplus_good_information", catalog = "")
public class GoodUserEntity {
    private long goodUserId;
    private String goodUserNickname;
    private String goodUserAvatarLink;

    @Id
    @Column(name = "good_user_id")
    public long getGoodUserId() {
        return goodUserId;
    }

    public void setGoodUserId(long goodUserId) {
        this.goodUserId = goodUserId;
    }

    @Basic
    @Column(name = "good_user_nickname")
    public String getGoodUserNickname() {
        return goodUserNickname;
    }

    public void setGoodUserNickname(String goodUserNickname) {
        this.goodUserNickname = goodUserNickname;
    }

    @Basic
    @Column(name = "good_user_avatar_link")
    public String getGoodUserAvatarLink() {
        return goodUserAvatarLink;
    }

    public void setGoodUserAvatarLink(String goodUserAvatarLink) {
        this.goodUserAvatarLink = goodUserAvatarLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodUserEntity that = (GoodUserEntity) o;
        return goodUserId == that.goodUserId && Objects.equals(goodUserNickname, that.goodUserNickname) && Objects.equals(goodUserAvatarLink, that.goodUserAvatarLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodUserId, goodUserNickname, goodUserAvatarLink);
    }
}
