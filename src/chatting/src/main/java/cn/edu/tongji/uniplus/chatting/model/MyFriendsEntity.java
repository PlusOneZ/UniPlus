package cn.edu.tongji.uniplus.chatting.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName MyFriendsEntity.java
 * @Description TODO
 * @createTime 2021年12月06日 13:42:00
 */
@Entity
@Table(name = "my_friends", schema = "uniplus_chatting", catalog = "")
public class MyFriendsEntity {
    private long id;
    private String myUserId;
    private String myFriendUserId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "my_user_id")
    public String getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId;
    }

    @Basic
    @Column(name = "my_friend_user_id")
    public String getMyFriendUserId() {
        return myFriendUserId;
    }

    public void setMyFriendUserId(String myFriendUserId) {
        this.myFriendUserId = myFriendUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFriendsEntity that = (MyFriendsEntity) o;
        return id == that.id && Objects.equals(myUserId, that.myUserId) && Objects.equals(myFriendUserId, that.myFriendUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, myUserId, myFriendUserId);
    }
}
