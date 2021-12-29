package cn.edu.tongji.uniplus.user.payload;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * UserForQueue
 *
 * @author 卓正一
 * @since 2021/12/1 5:24 PM
 */
public class UserForQueue implements Serializable {

    private Long userId;
    private String userName;

    public UserForQueue() {

    }

    public UserForQueue(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "" + getUserId());
        map.put("nickName", getUserName());

        return map;
    }
}
