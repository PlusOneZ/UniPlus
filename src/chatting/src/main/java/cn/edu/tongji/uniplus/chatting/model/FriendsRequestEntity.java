package cn.edu.tongji.uniplus.chatting.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName FriendsRequestEntity.java
 * @Description TODO
 * @createTime 2021年12月06日 13:42:00
 */
@Entity
@Table(name = "friends_request", schema = "uniplus_chatting", catalog = "")
public class FriendsRequestEntity {
    private long requestId;
    private String sendUserId;
    private String acceptUserId;
    private Timestamp requestTime;

    @Id
    @Column(name = "request_id")
    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "send_user_id")
    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    @Basic
    @Column(name = "accept_user_id")
    public String getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    @Basic
    @Column(name = "request_time")
    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsRequestEntity that = (FriendsRequestEntity) o;
        return requestId == that.requestId && Objects.equals(sendUserId, that.sendUserId) && Objects.equals(acceptUserId, that.acceptUserId) && Objects.equals(requestTime, that.requestTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, sendUserId, acceptUserId, requestTime);
    }
}
