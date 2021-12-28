package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class NearbyUserLikePlaceEntityPK implements Serializable {
    private long likeUserId;
    private int likePlaceId;

    @Column(name = "like_user_id")
    @Id
    public long getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(long likeUserId) {
        this.likeUserId = likeUserId;
    }

    @Column(name = "like_place_id")
    @Id
    public int getLikePlaceId() {
        return likePlaceId;
    }

    public void setLikePlaceId(int likePlaceId) {
        this.likePlaceId = likePlaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NearbyUserLikePlaceEntityPK that = (NearbyUserLikePlaceEntityPK) o;
        return likeUserId == that.likeUserId && likePlaceId == that.likePlaceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeUserId, likePlaceId);
    }
}
