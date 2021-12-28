package cn.edu.tongji.uniplus.good_information.model;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodUserLikeGoodEntityPK implements Serializable {
    private long likeGoodId;
    private long likeUserId;

    @Column(name = "like_good_id")
    @Id
    public long getLikeGoodId() {
        return likeGoodId;
    }

    public void setLikeGoodId(long likeGoodId) {
        this.likeGoodId = likeGoodId;
    }

    @Column(name = "like_user_id")
    @Id
    public long getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(long likeUserId) {
        this.likeUserId = likeUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodUserLikeGoodEntityPK that = (GoodUserLikeGoodEntityPK) o;
        return likeGoodId == that.likeGoodId && likeUserId == that.likeUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeGoodId, likeUserId);
    }
}
