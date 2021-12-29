package cn.edu.tongji.uniplus.nearby_place.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nearby_user_like_place", schema = "uniplus_nearby_place", catalog = "")
@IdClass(NearbyUserLikePlaceEntityPK.class)
@DynamicInsert
public class NearbyUserLikePlaceEntity {
    private long likeUserId;
    private int likePlaceId;

    @Id
    @Column(name = "like_user_id")
    public long getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(long likeUserId) {
        this.likeUserId = likeUserId;
    }

    @Id
    @Column(name = "like_place_id")
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
        NearbyUserLikePlaceEntity that = (NearbyUserLikePlaceEntity) o;
        return likeUserId == that.likeUserId && likePlaceId == that.likePlaceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeUserId, likePlaceId);
    }
}
