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
@DynamicUpdate
@DynamicInsert
@Table(name = "good_good", schema = "uniplus_good_information", catalog = "")
public class GoodGoodEntity {
    private long goodId;
    private String goodTitle;
    private BigDecimal goodCurrentPrice;
    private BigDecimal goodOriginalPrice;
    private String goodSellUnit;
    private int goodStock;
    private String goodDescription;
    private int goodClassification;
    private Timestamp goodCreateTime;
    private long goodOwnerId;

    @Id
    @Column(name = "good_id")
    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    @Basic
    @Column(name = "good_title")
    public String getGoodTitle() {
        return goodTitle;
    }

    public void setGoodTitle(String goodTitle) {
        this.goodTitle = goodTitle;
    }

    @Basic
    @Column(name = "good_current_price")
    public BigDecimal getGoodCurrentPrice() {
        return goodCurrentPrice;
    }

    public void setGoodCurrentPrice(BigDecimal goodCurrentPrice) {
        this.goodCurrentPrice = goodCurrentPrice;
    }

    @Basic
    @Column(name = "good_original_price")
    public BigDecimal getGoodOriginalPrice() {
        return goodOriginalPrice;
    }

    public void setGoodOriginalPrice(BigDecimal goodOriginalPrice) {
        this.goodOriginalPrice = goodOriginalPrice;
    }

    @Basic
    @Column(name = "good_sell_unit")
    public String getGoodSellUnit() {
        return goodSellUnit;
    }

    public void setGoodSellUnit(String goodSellUnit) {
        this.goodSellUnit = goodSellUnit;
    }

    @Basic
    @Column(name = "good_stock")
    public int getGoodStock() {
        return goodStock;
    }

    public void setGoodStock(int goodStock) {
        this.goodStock = goodStock;
    }

    @Basic
    @Column(name = "good_description")
    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    @Basic
    @Column(name = "good_classification")
    public int getGoodClassification() {
        return goodClassification;
    }

    public void setGoodClassification(int goodClassification) {
        this.goodClassification = goodClassification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodGoodEntity that = (GoodGoodEntity) o;
        return goodId == that.goodId && goodStock == that.goodStock && goodClassification == that.goodClassification && Objects.equals(goodTitle, that.goodTitle) && Objects.equals(goodCurrentPrice, that.goodCurrentPrice) && Objects.equals(goodOriginalPrice, that.goodOriginalPrice) && Objects.equals(goodSellUnit, that.goodSellUnit) && Objects.equals(goodDescription, that.goodDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, goodTitle, goodCurrentPrice, goodOriginalPrice, goodSellUnit, goodStock, goodDescription, goodClassification);
    }

    @Basic
    @Column(name = "good_create_time")
    public Timestamp getGoodCreateTime() {
        return goodCreateTime;
    }

    public void setGoodCreateTime(Timestamp goodCreateTime) {
        this.goodCreateTime = goodCreateTime;
    }

    @Basic
    @Column(name = "good_owner_id")
    public long getGoodOwnerId() {
        return goodOwnerId;
    }

    public void setGoodOwnerId(long goodOwnerId) {
        this.goodOwnerId = goodOwnerId;
    }
}
