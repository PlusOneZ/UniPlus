package cn.edu.tongji.uniplus.good_information.model;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodShoppingCartEntityPK implements Serializable {
    private long cartUserId;
    private long cartGoodId;

    @Column(name = "cart_user_id")
    @Id
    public long getCartUserId() {
        return cartUserId;
    }

    public void setCartUserId(long cartUserId) {
        this.cartUserId = cartUserId;
    }

    @Column(name = "cart_good_id")
    @Id
    public long getCartGoodId() {
        return cartGoodId;
    }

    public void setCartGoodId(long cartGoodId) {
        this.cartGoodId = cartGoodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodShoppingCartEntityPK that = (GoodShoppingCartEntityPK) o;
        return cartUserId == that.cartUserId && cartGoodId == that.cartGoodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartUserId, cartGoodId);
    }
}
