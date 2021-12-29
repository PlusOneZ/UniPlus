package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlaceRouteShareTagEntityPK implements Serializable {
    private int placeRouteShareId;
    private String placeRouteShareTag;

    @Column(name = "place_route_share_id")
    @Id
    public int getPlaceRouteShareId() {
        return placeRouteShareId;
    }

    public void setPlaceRouteShareId(int placeRouteShareId) {
        this.placeRouteShareId = placeRouteShareId;
    }

    @Column(name = "place_route_share_tag")
    @Id
    public String getPlaceRouteShareTag() {
        return placeRouteShareTag;
    }

    public void setPlaceRouteShareTag(String placeRouteShareTag) {
        this.placeRouteShareTag = placeRouteShareTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceRouteShareTagEntityPK that = (PlaceRouteShareTagEntityPK) o;
        return placeRouteShareId == that.placeRouteShareId && Objects.equals(placeRouteShareTag, that.placeRouteShareTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeRouteShareId, placeRouteShareTag);
    }
}
