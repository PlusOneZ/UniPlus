package cn.edu.tongji.uniplus.carpooling.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName OrderGroupEntity.java
 * @Description TODO
 * @createTime 2021年12月30日 16:01:00
 */
@Entity
@Table(name = "order_group", schema = "uniplus_polling_share", catalog = "")
public class OrderGroupEntity {
    private String orderId;
    private Integer joinmode;
    private Long ownerId;
    private Integer magree;
    private String msg;
    private String orderName;
    private Integer price;

    @Id
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "joinmode")
    public Integer getJoinmode() {
        return joinmode;
    }

    public void setJoinmode(Integer joinmode) {
        this.joinmode = joinmode;
    }

    @Basic
    @Column(name = "owner_id")
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "magree")
    public Integer getMagree() {
        return magree;
    }

    public void setMagree(Integer magree) {
        this.magree = magree;
    }

    @Basic
    @Column(name = "msg")
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Basic
    @Column(name = "order_name")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderGroupEntity that = (OrderGroupEntity) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(joinmode, that.joinmode) && Objects.equals(ownerId, that.ownerId) && Objects.equals(magree, that.magree) && Objects.equals(msg, that.msg) && Objects.equals(orderName, that.orderName) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, joinmode, ownerId, magree, msg, orderName, price);
    }
}
