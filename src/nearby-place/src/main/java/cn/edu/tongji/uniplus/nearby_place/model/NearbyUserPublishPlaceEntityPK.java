package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class NearbyUserPublishPlaceEntityPK implements Serializable {
    private int publishPlaceId;
    private long publishUserId;

    @Column(name = "publish_place_id")
    @Id
    public int getPublishPlaceId() {
        return publishPlaceId;
    }

    public void setPublishPlaceId(int publishPlaceId) {
        this.publishPlaceId = publishPlaceId;
    }

    @Column(name = "publish_user_id")
    @Id
    public long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(long publishUserId) {
        this.publishUserId = publishUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NearbyUserPublishPlaceEntityPK that = (NearbyUserPublishPlaceEntityPK) o;
        return publishPlaceId == that.publishPlaceId && publishUserId == that.publishUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishPlaceId, publishUserId);
    }
}
