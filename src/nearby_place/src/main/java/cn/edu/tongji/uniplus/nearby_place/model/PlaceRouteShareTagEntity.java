package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "place_route_share_tag", schema = "uniplus_nearby_place", catalog = "")
@IdClass(PlaceRouteShareTagEntityPK.class)
public class PlaceRouteShareTagEntity {
    private int placeRouteShareId;
    private String placeRouteShareTag;

    @Id
    @Column(name = "place_route_share_id")
    public int getPlaceRouteShareId() {
        return placeRouteShareId;
    }

    public void setPlaceRouteShareId(int placeRouteShareId) {
        this.placeRouteShareId = placeRouteShareId;
    }

    @Id
    @Column(name = "place_route_share_tag")
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
        PlaceRouteShareTagEntity that = (PlaceRouteShareTagEntity) o;
        return placeRouteShareId == that.placeRouteShareId && Objects.equals(placeRouteShareTag, that.placeRouteShareTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeRouteShareId, placeRouteShareTag);
    }
}
