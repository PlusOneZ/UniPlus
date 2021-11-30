package cn.edu.tongji.uniplus.good_information.model;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "good_user_like_good", schema = "uniplus_good_information", catalog = "")
@IdClass(GoodUserLikeGoodEntityPK.class)
public class GoodUserLikeGoodEntity {
    private long likeGoodId;
    private long likeUserId;
    private Timestamp likeTime;

    @Id
    @Column(name = "like_good_id")
    public long getLikeGoodId() {
        return likeGoodId;
    }

    public void setLikeGoodId(long likeGoodId) {
        this.likeGoodId = likeGoodId;
    }

    @Id
    @Column(name = "like_user_id")
    public long getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(long likeUserId) {
        this.likeUserId = likeUserId;
    }

    @Basic
    @Column(name = "like_time")
    public Timestamp getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Timestamp likeTime) {
        this.likeTime = likeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodUserLikeGoodEntity that = (GoodUserLikeGoodEntity) o;
        return likeGoodId == that.likeGoodId && likeUserId == that.likeUserId && Objects.equals(likeTime, that.likeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeGoodId, likeUserId, likeTime);
    }
}
