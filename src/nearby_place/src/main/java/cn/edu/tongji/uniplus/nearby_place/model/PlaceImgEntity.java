package cn.edu.tongji.uniplus.nearby_place.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "place_img", schema = "uniplus_nearby_place", catalog = "")
@IdClass(PlaceImgEntityPK.class)
@DynamicInsert
public class PlaceImgEntity {
    private int placeId;
    private String imgLink;
    private int placeImgIndex;

    @Id
    @Column(name = "place_id")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Id
    @Column(name = "img_link")
    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Basic
    @Column(name = "place_img_index")
    public int getPlaceImgIndex() {
        return placeImgIndex;
    }

    public void setPlaceImgIndex(int placeImgIndex) {
        this.placeImgIndex = placeImgIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceImgEntity that = (PlaceImgEntity) o;
        return placeId == that.placeId && placeImgIndex == that.placeImgIndex && Objects.equals(imgLink, that.imgLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, imgLink, placeImgIndex);
    }
}
