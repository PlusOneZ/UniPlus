package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "nearby_user_publish_place", schema = "uniplus_nearby_place", catalog = "")
@IdClass(NearbyUserPublishPlaceEntityPK.class)
public class NearbyUserPublishPlaceEntity {
    private int publishPlaceId;
    private long publishUserId;
    private Timestamp publishTime;

    @Id
    @Column(name = "publish_place_id")
    public int getPublishPlaceId() {
        return publishPlaceId;
    }

    public void setPublishPlaceId(int publishPlaceId) {
        this.publishPlaceId = publishPlaceId;
    }

    @Id
    @Column(name = "publish_user_id")
    public long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(long publishUserId) {
        this.publishUserId = publishUserId;
    }

    @Basic
    @Column(name = "publish_time")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NearbyUserPublishPlaceEntity that = (NearbyUserPublishPlaceEntity) o;
        return publishPlaceId == that.publishPlaceId && publishUserId == that.publishUserId && Objects.equals(publishTime, that.publishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishPlaceId, publishUserId, publishTime);
    }
}
