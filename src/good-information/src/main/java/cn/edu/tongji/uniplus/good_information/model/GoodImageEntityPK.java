package cn.edu.tongji.uniplus.good_information.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * GoodImageEntityPK
 *
 * @author 卓正一
 * @since 2021/12/30 6:21 AM
 */
public class GoodImageEntityPK implements Serializable {
    private long goodId;
    private int goodImageIndex;

    @Column(name = "good_id")
    @Id
    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    @Column(name = "good_image_index")
    @Id
    public int getGoodImageIndex() {
        return goodImageIndex;
    }

    public void setGoodImageIndex(int goodImageIndex) {
        this.goodImageIndex = goodImageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodImageEntityPK that = (GoodImageEntityPK) o;
        return goodId == that.goodId && goodImageIndex == that.goodImageIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, goodImageIndex);
    }
}
