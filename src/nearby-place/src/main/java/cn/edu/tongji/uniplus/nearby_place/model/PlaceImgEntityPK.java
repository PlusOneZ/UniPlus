package cn.edu.tongji.uniplus.nearby_place.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlaceImgEntityPK implements Serializable {
    private int placeId;
    private String imgLink;

    @Column(name = "place_id")
    @Id
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Column(name = "img_link")
    @Id
    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceImgEntityPK that = (PlaceImgEntityPK) o;
        return placeId == that.placeId && Objects.equals(imgLink, that.imgLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, imgLink);
    }
}
