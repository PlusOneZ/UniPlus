package cn.edu.tongji.uniplus.nearby_place.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "place_comment", schema = "uniplus_nearby_place", catalog = "")
public class PlaceCommentEntity {
    private long placeCommentId;
    private Timestamp placeCommentTime;
    private long placeCommentUser;
    private int placeCommentOnPlace;
    private String placeCommentContent;
    private int commentRating;

    @Id
    @Column(name = "place_comment_id")
    public long getPlaceCommentId() {
        return placeCommentId;
    }

    public void setPlaceCommentId(long placeCommentId) {
        this.placeCommentId = placeCommentId;
    }

    @Basic
    @Column(name = "place_comment_time")
    public Timestamp getPlaceCommentTime() {
        return placeCommentTime;
    }

    public void setPlaceCommentTime(Timestamp placeCommentTime) {
        this.placeCommentTime = placeCommentTime;
    }

    @Basic
    @Column(name = "place_comment_user")
    public long getPlaceCommentUser() {
        return placeCommentUser;
    }

    public void setPlaceCommentUser(long placeCommentUser) {
        this.placeCommentUser = placeCommentUser;
    }

    @Basic
    @Column(name = "place_comment_on_place")
    public int getPlaceCommentOnPlace() {
        return placeCommentOnPlace;
    }

    public void setPlaceCommentOnPlace(int placeCommentOnPlace) {
        this.placeCommentOnPlace = placeCommentOnPlace;
    }

    @Basic
    @Column(name = "place_comment_content")
    public String getPlaceCommentContent() {
        return placeCommentContent;
    }

    public void setPlaceCommentContent(String placeCommentContent) {
        this.placeCommentContent = placeCommentContent;
    }

    @Basic
    @Column(name = "comment_rating")
    public int getCommentRating() {
        return commentRating;
    }

    public void setCommentRating(int commentRating) {
        this.commentRating = commentRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceCommentEntity that = (PlaceCommentEntity) o;
        return placeCommentId == that.placeCommentId && placeCommentUser == that.placeCommentUser && placeCommentOnPlace == that.placeCommentOnPlace && commentRating == that.commentRating && Objects.equals(placeCommentTime, that.placeCommentTime) && Objects.equals(placeCommentContent, that.placeCommentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeCommentId, placeCommentTime, placeCommentUser, placeCommentOnPlace, placeCommentContent, commentRating);
    }
}
