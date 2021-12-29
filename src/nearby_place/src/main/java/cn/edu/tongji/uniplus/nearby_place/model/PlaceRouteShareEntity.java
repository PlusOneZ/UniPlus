package cn.edu.tongji.uniplus.nearby_place.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "place_route_share", schema = "uniplus_nearby_place", catalog = "")
public class PlaceRouteShareEntity {
    private int routeShareId;
    private String shareRouteTitle;
    private String shareRouteContent;
    private Long routePublisherId;

    @Id
    @Column(name = "route_share_id")
    public int getRouteShareId() {
        return routeShareId;
    }

    public void setRouteShareId(int routeShareId) {
        this.routeShareId = routeShareId;
    }

    @Basic
    @Column(name = "share_route_title")
    public String getShareRouteTitle() {
        return shareRouteTitle;
    }

    public void setShareRouteTitle(String shareRouteTitle) {
        this.shareRouteTitle = shareRouteTitle;
    }

    @Basic
    @Column(name = "share_route_content")
    public String getShareRouteContent() {
        return shareRouteContent;
    }

    public void setShareRouteContent(String shareRouteContent) {
        this.shareRouteContent = shareRouteContent;
    }

    @Basic
    @Column(name = "route_publisher_id")
    public Long getRoutePublisherId() {
        return routePublisherId;
    }

    public void setRoutePublisherId(Long routePublisherId) {
        this.routePublisherId = routePublisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceRouteShareEntity that = (PlaceRouteShareEntity) o;
        return routeShareId == that.routeShareId && Objects.equals(shareRouteTitle, that.shareRouteTitle) && Objects.equals(shareRouteContent, that.shareRouteContent) && Objects.equals(routePublisherId, that.routePublisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeShareId, shareRouteTitle, shareRouteContent, routePublisherId);
    }
}
