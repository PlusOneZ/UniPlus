package cn.edu.tongji.uniplus.good_information.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "good_image", schema = "uniplus_good_information", catalog = "")
@IdClass(GoodImageEntityPK.class)
public class GoodImageEntity {
    private long goodId;
    private int goodImageIndex;
    private String goodImageUrl;

    @Id
    @Column(name = "good_id")
    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    @Id
    @Column(name = "good_image_index")
    public int getGoodImageIndex() {
        return goodImageIndex;
    }

    public void setGoodImageIndex(int goodImageIndex) {
        this.goodImageIndex = goodImageIndex;
    }

    @Basic
    @Column(name = "good_image_url")
    public String getGoodImageUrl() {
        return goodImageUrl;
    }

    public void setGoodImageUrl(String goodImageUrl) {
        this.goodImageUrl = goodImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodImageEntity that = (GoodImageEntity) o;
        return goodId == that.goodId && goodImageIndex == that.goodImageIndex && Objects.equals(goodImageUrl, that.goodImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, goodImageIndex, goodImageUrl);
    }
}
