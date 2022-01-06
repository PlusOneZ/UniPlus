package cn.edu.tongji.uniplus.nearby_place.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "nearby_user", schema = "uniplus_nearby_place", catalog = "")
public class NearbyUserEntity {
    private long userId;
    private String userNickname;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_nickname")
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NearbyUserEntity that = (NearbyUserEntity) o;
        return userId == that.userId && Objects.equals(userNickname, that.userNickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userNickname);
    }
}
