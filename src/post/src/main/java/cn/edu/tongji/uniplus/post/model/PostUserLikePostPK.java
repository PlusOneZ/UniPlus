package cn.edu.tongji.uniplus.post.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostUserLikePostPK implements Serializable {
    private long postLikePostId;
    private long postLikeUserId;

    @Column(name = "post_like_post_id")
    @Id
    public long getPostLikePostId() {
        return postLikePostId;
    }

    public void setPostLikePostId(long postLikePostId) {
        this.postLikePostId = postLikePostId;
    }

    @Column(name = "post_like_user_id")
    @Id
    public long getPostLikeUserId() {
        return postLikeUserId;
    }

    public void setPostLikeUserId(long postLikeUserId) {
        this.postLikeUserId = postLikeUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUserLikePostPK that = (PostUserLikePostPK) o;
        return postLikePostId == that.postLikePostId && postLikeUserId == that.postLikeUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postLikePostId, postLikeUserId);
    }
}
