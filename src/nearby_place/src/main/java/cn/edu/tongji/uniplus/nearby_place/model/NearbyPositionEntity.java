package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nearby_position", schema = "uniplus_nearby_place", catalog = "")
public class NearbyPositionEntity {
    private int positionId;
    private String positionName;
    private double positionLatitude;
    private double positionLongitude;

    @Id
    @Column(name = "position_id")
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Basic
    @Column(name = "position_name")
    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Basic
    @Column(name = "position_latitude")
    public double getPositionLatitude() {
        return positionLatitude;
    }

    public void setPositionLatitude(double positionLatitude) {
        this.positionLatitude = positionLatitude;
    }

    @Basic
    @Column(name = "position_longitude")
    public double getPositionLongitude() {
        return positionLongitude;
    }

    public void setPositionLongitude(double positionLongitude) {
        this.positionLongitude = positionLongitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NearbyPositionEntity that = (NearbyPositionEntity) o;
        return positionId == that.positionId && Double.compare(that.positionLatitude, positionLatitude) == 0 && Double.compare(that.positionLongitude, positionLongitude) == 0 && Objects.equals(positionName, that.positionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionId, positionName, positionLatitude, positionLongitude);
    }
}
