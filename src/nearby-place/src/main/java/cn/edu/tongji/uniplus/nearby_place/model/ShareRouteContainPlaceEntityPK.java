package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ShareRouteContainPlaceEntityPK implements Serializable {
    private int routeShareId;
    private int routePlaceId;
    private int sharePlaceIndex;

    @Column(name = "route_share_id")
    @Id
    public int getRouteShareId() {
        return routeShareId;
    }

    public void setRouteShareId(int routeShareId) {
        this.routeShareId = routeShareId;
    }

    @Column(name = "route_place_id")
    @Id
    public int getRoutePlaceId() {
        return routePlaceId;
    }

    public void setRoutePlaceId(int routePlaceId) {
        this.routePlaceId = routePlaceId;
    }

    @Column(name = "share_place_index")
    @Id
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
        ShareRouteContainPlaceEntityPK that = (ShareRouteContainPlaceEntityPK) o;
        return routeShareId == that.routeShareId && routePlaceId == that.routePlaceId && sharePlaceIndex == that.sharePlaceIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeShareId, routePlaceId, sharePlaceIndex);
    }
}
