package cn.edu.tongji.uniplus.post.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_user_like_reply", schema = "uniplus_post", catalog = "")
@IdClass(PostUserLikeReplyPK.class)
public class PostUserLikeReply {
    private long replyLikeReplyId;
    private long replyLikeUserId;

    @Id
    @Column(name = "reply_like_reply_id")
    public long getReplyLikeReplyId() {
        return replyLikeReplyId;
    }

    public void setReplyLikeReplyId(long replyLikeReplyId) {
        this.replyLikeReplyId = replyLikeReplyId;
    }

    @Id
    @Column(name = "reply_like_user_id")
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
        PostUserLikeReply that = (PostUserLikeReply) o;
        return replyLikeReplyId == that.replyLikeReplyId && replyLikeUserId == that.replyLikeUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyLikeReplyId, replyLikeUserId);
    }
}
