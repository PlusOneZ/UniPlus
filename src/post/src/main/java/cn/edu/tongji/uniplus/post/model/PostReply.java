package cn.edu.tongji.uniplus.post.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "post_reply", schema = "uniplus_post", catalog = "")
public class PostReply {
    private long replyId;
    private Timestamp replyTime;
    private String replyContent;
    private Integer replyLikeCount;
    private Long parentReplyId;
    private Long replyUserId;
    private Long replyPostId;

    @Id
    @Column(name = "reply_id")
    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    @Basic
    @Column(name = "reply_time")
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    @Basic
    @Column(name = "reply_content")
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "reply_like_count")
    public Integer getReplyLikeCount() {
        return replyLikeCount;
    }

    public void setReplyLikeCount(Integer replyLikeCount) {
        this.replyLikeCount = replyLikeCount;
    }

    @Basic
    @Column(name = "parent_reply_id")
    public Long getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(Long parentReplyId) {
        this.parentReplyId = parentReplyId;
    }

    @Basic
    @Column(name = "reply_user_id")
    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    @Basic
    @Column(name = "reply_post_id")
    public Long getReplyPostId() {
        return replyPostId;
    }

    public void setReplyPostId(Long replyPostId) {
        this.replyPostId = replyPostId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostReply postReply = (PostReply) o;
        return replyId == postReply.replyId && Objects.equals(replyTime, postReply.replyTime) && Objects.equals(replyContent, postReply.replyContent) && Objects.equals(replyLikeCount, postReply.replyLikeCount) && Objects.equals(parentReplyId, postReply.parentReplyId) && Objects.equals(replyUserId, postReply.replyUserId) && Objects.equals(replyPostId, postReply.replyPostId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, replyTime, replyContent, replyLikeCount, parentReplyId, replyUserId, replyPostId);
    }
}
