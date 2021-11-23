package cn.edu.tongji.uniplus.nearby_place.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "nearby_place", schema = "uniplus_nearby_place", catalog = "")
public class NearbyPlaceEntity {
    private int placeId;
    private String placeName;
    private int placeType;
    private String placePhone;
    private String placeAddressText;
    private String placeOrigin;
    private int placePosition;

    @Id
    @Column(name = "place_id")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "place_name")
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Basic
    @Column(name = "place_type")
    public int getPlaceType() {
        return placeType;
    }

    public void setPlaceType(int placeType) {
        this.placeType = placeType;
    }

    @Basic
    @Column(name = "place_phone")
    public String getPlacePhone() {
        return placePhone;
    }

    public void setPlacePhone(String placePhone) {
        this.placePhone = placePhone;
    }

    @Basic
    @Column(name = "place_address_text")
    public String getPlaceAddressText() {
        return placeAddressText;
    }

    public void setPlaceAddressText(String placeAddressText) {
        this.placeAddressText = placeAddressText;
    }

    @Basic
    @Column(name = "place_origin")
    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    @Basic
    @Column(name = "place_position")
    public int getPlacePosition() {
        return placePosition;
    }

    public void setPlacePosition(int placePosition) {
        this.placePosition = placePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NearbyPlaceEntity that = (NearbyPlaceEntity) o;
        return placeId == that.placeId && placeType == that.placeType && placePosition == that.placePosition && Objects.equals(placeName, that.placeName) && Objects.equals(placePhone, that.placePhone) && Objects.equals(placeAddressText, that.placeAddressText) && Objects.equals(placeOrigin, that.placeOrigin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, placeName, placeType, placePhone, placeAddressText, placeOrigin, placePosition);
    }
}
