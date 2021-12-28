package cn.edu.tongji.uniplus.nearby_place.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "share_route_contain_place", schema = "uniplus_nearby_place", catalog = "")
@IdClass(ShareRouteContainPlaceEntityPK.class)
@DynamicInsert
public class ShareRouteContainPlaceEntity {
    private int routeShareId;
    private int routePlaceId;
    private int sharePlaceIndex;

    @Id
    @Column(name = "route_share_id")
    public int getRouteShareId() {
        return routeShareId;
    }

    public void setRouteShareId(int routeShareId) {
        this.routeShareId = routeShareId;
    }

    @Id
    @Column(name = "route_place_id")
    public int getRoutePlaceId() {
        return routePlaceId;
    }

    public void setRoutePlaceId(int routePlaceId) {
        this.routePlaceId = routePlaceId;
    }

    @Id
    @Column(name = "share_place_index")
    public int getSharePlaceIndex() {
        return sharePlaceIndex;
    }

    public void setSharePlaceIndex(int sharePlaceIndex) {
        this.sharePlaceIndex = sharePlaceIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShareRouteContainPlaceEntity that = (ShareRouteContainPlaceEntity) o;
        return routeShareId == that.routeShareId && routePlaceId == that.routePlaceId && sharePlaceIndex == that.sharePlaceIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeShareId, routePlaceId, sharePlaceIndex);
    }
}
