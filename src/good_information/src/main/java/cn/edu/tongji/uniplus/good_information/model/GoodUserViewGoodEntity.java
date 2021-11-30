package cn.edu.tongji.uniplus.good_information.model;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "good_user_view_good", schema = "uniplus_good_information", catalog = "")
public class GoodUserViewGoodEntity {
    private long viewGoodId;
    private Long viewGoodUserId;
    private long viewId;
    private Timestamp viewTime;

    @Basic
    @Column(name = "view_good_id")
    public long getViewGoodId() {
        return viewGoodId;
    }

    public void setViewGoodId(long viewGoodId) {
        this.viewGoodId = viewGoodId;
    }

    @Basic
    @Column(name = "view_good_user_id")
    public Long getViewGoodUserId() {
        return viewGoodUserId;
    }

    public void setViewGoodUserId(Long viewGoodUserId) {
        this.viewGoodUserId = viewGoodUserId;
    }

    @Id
    @Column(name = "view_id")
    public long getViewId() {
        return viewId;
    }

    public void setViewId(long viewId) {
        this.viewId = viewId;
    }

    @Basic
    @Column(name = "view_time")
    public Timestamp getViewTime() {
        return viewTime;
    }

    public void setViewTime(Timestamp viewTime) {
        this.viewTime = viewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodUserViewGoodEntity that = (GoodUserViewGoodEntity) o;
        return viewGoodId == that.viewGoodId && viewId == that.viewId && Objects.equals(viewGoodUserId, that.viewGoodUserId) && Objects.equals(viewTime, that.viewTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viewGoodId, viewGoodUserId, viewId, viewTime);
    }
}
