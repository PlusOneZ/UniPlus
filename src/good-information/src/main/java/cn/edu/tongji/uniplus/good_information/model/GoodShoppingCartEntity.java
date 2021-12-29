package cn.edu.tongji.uniplus.good_information.model;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "good_shopping_cart", schema = "uniplus_good_information", catalog = "")
@IdClass(GoodShoppingCartEntityPK.class)
@DynamicInsert
@DynamicUpdate
public class GoodShoppingCartEntity {
    private long cartUserId;
    private long cartGoodId;
    private int cartGoodAmount;
    private Timestamp cartGoodAddTime;
    private BigDecimal cartAddOriginalPrice;

    @Id
    @Column(name = "cart_user_id")
    public long getCartUserId() {
        return cartUserId;
    }

    public void setCartUserId(long cartUserId) {
        this.cartUserId = cartUserId;
    }

    @Id
    @Column(name = "cart_good_id")
    public long getCartGoodId() {
        return cartGoodId;
    }

    public void setCartGoodId(long cartGoodId) {
        this.cartGoodId = cartGoodId;
    }

    @Basic
    @Column(name = "cart_good_amount")
    public int getCartGoodAmount() {
        return cartGoodAmount;
    }

    public void setCartGoodAmount(int cartGoodAmount) {
        this.cartGoodAmount = cartGoodAmount;
    }

    @Basic
    @Column(name = "cart_good_add_time")
    public Timestamp getCartGoodAddTime() {
        return cartGoodAddTime;
    }

    public void setCartGoodAddTime(Timestamp cartGoodAddTime) {
        this.cartGoodAddTime = cartGoodAddTime;
    }

    @Basic
    @Column(name = "cart_add_original_price")
    public BigDecimal getCartAddOriginalPrice() {
        return cartAddOriginalPrice;
    }

    public void setCartAddOriginalPrice(BigDecimal cartAddOriginalPrice) {
        this.cartAddOriginalPrice = cartAddOriginalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodShoppingCartEntity that = (GoodShoppingCartEntity) o;
        return cartUserId == that.cartUserId && cartGoodId == that.cartGoodId && cartGoodAmount == that.cartGoodAmount && Objects.equals(cartGoodAddTime, that.cartGoodAddTime) && Objects.equals(cartAddOriginalPrice, that.cartAddOriginalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartUserId, cartGoodId, cartGoodAmount, cartGoodAddTime, cartAddOriginalPrice);
    }
}
