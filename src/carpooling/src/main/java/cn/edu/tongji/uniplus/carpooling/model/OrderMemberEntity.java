package cn.edu.tongji.uniplus.carpooling.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderMemberEntity.java
 * @Description TODO
 * @createTime 2021年12月29日 21:27:00
 */
@Entity
@Table(name = "order_member", schema = "uniplus_polling_share", catalog = "")
public class OrderMemberEntity {
    private long id;
    private String orderId;
    private Long memberId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "member_id")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMemberEntity that = (OrderMemberEntity) o;
        return id == that.id && Objects.equals(orderId, that.orderId) && Objects.equals(memberId, that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, memberId);
    }
}
