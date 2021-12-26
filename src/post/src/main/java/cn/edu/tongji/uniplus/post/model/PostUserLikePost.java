package cn.edu.tongji.uniplus.post.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post_user_like_post", schema = "uniplus_post", catalog = "")
@IdClass(PostUserLikePostPK.class)
public class PostUserLikePost {
    private long postLikePostId;
    private long postLikeUserId;
    private Timestamp postLikePostTime;

    @Id
    @Column(name = "post_like_post_id")
    public long getPostLikePostId() {
        return postLikePostId;
    }

    public void setPostLikePostId(long postLikePostId) {
        this.postLikePostId = postLikePostId;
    }

    @Id
    @Column(name = "post_like_user_id")
    public long getPostLikeUserId() {
        return postLikeUserId;
    }

    public void setPostLikeUserId(long postLikeUserId) {
        this.postLikeUserId = postLikeUserId;
    }

    @Basic
    @Column(name = "post_like_post_time")
    public Timestamp getPostLikePostTime() {
        return postLikePostTime;
    }

    public void setPostLikePostTime(Timestamp postLikePostTime) {
        this.postLikePostTime = postLikePostTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUserLikePost that = (PostUserLikePost) o;
        return postLikePostId == that.postLikePostId && postLikeUserId == that.postLikeUserId && Objects.equals(postLikePostTime, that.postLikePostTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postLikePostId, postLikeUserId, postLikePostTime);
    }
}
