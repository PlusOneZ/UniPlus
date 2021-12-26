package cn.edu.tongji.uniplus.post.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Post {
    private long postId;
    private Long postUserId;
    private Timestamp postTime;
    private String postContent;
    private String postTitle;
    private int postAreaId;
    private int postLikeCount;
    private int postReplyCount;

    @Id
    @Column(name = "post_id")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "post_user_id")
    public Long getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(Long postUserId) {
        this.postUserId = postUserId;
    }

    @Basic
    @Column(name = "post_time")
    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Basic
    @Column(name = "post_content")
    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Basic
    @Column(name = "post_title")
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Basic
    @Column(name = "post_area_id")
    public int getPostAreaId() {
        return postAreaId;
    }

    public void setPostAreaId(int postAreaId) {
        this.postAreaId = postAreaId;
    }

    @Basic
    @Column(name = "post_like_count")
    public int getPostLikeCount() {
        return postLikeCount;
    }

    public void setPostLikeCount(int postLikeCount) {
        this.postLikeCount = postLikeCount;
    }

    @Basic
    @Column(name = "post_reply_count")
    public int getPostReplyCount() {
        return postReplyCount;
    }

    public void setPostReplyCount(int postReplyCount) {
        this.postReplyCount = postReplyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId && postAreaId == post.postAreaId && postLikeCount == post.postLikeCount && postReplyCount == post.postReplyCount && Objects.equals(postUserId, post.postUserId) && Objects.equals(postTime, post.postTime) && Objects.equals(postContent, post.postContent) && Objects.equals(postTitle, post.postTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postUserId, postTime, postContent, postTitle, postAreaId, postLikeCount, postReplyCount);
    }
}
