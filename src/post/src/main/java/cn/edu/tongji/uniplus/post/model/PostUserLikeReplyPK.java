package cn.edu.tongji.uniplus.post.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostUserLikeReplyPK implements Serializable {
    private long replyLikeReplyId;
    private long replyLikeUserId;

    @Column(name = "reply_like_reply_id")
    @Id
    public long getReplyLikeReplyId() {
        return replyLikeReplyId;
    }

    public void setReplyLikeReplyId(long replyLikeReplyId) {
        this.replyLikeReplyId = replyLikeReplyId;
    }

    @Column(name = "reply_like_user_id")
    @Id
    public long getReplyLikeUserId() {
        return replyLikeUserId;
    }

    public void setReplyLikeUserId(long replyLikeUserId) {
        this.replyLikeUserId = replyLikeUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUserLikeReplyPK that = (PostUserLikeReplyPK) o;
        return replyLikeReplyId == that.replyLikeReplyId && replyLikeUserId == that.replyLikeUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyLikeReplyId, replyLikeUserId);
    }
}
