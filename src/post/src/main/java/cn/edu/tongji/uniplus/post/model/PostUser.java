package cn.edu.tongji.uniplus.post.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_user", schema = "uniplus_post", catalog = "")
public class PostUser {
    private long postUserId;
    private String userNickName;

    @Id
    @Column(name = "post_user_id")
    public long getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(long postUserId) {
        this.postUserId = postUserId;
    }

    @Basic
    @Column(name = "user_nick_name")
    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUser postUser = (PostUser) o;
        return postUserId == postUser.postUserId && Objects.equals(userNickName, postUser.userNickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postUserId, userNickName);
    }
}
