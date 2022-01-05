package cn.edu.tongji.uniplus.notificationcenter.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * OrderEntity
 *
 * @author 卓正一
 * @since 2021/12/30 3:37 AM
 */
@Data
@NoArgsConstructor
public class NotificationCreationEntity {

    private String content;
    private String title;
    private Long receiverId;
    private Long senderId;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("receiverId", receiverId.toString());
        map.put("senderId", senderId.toString());
        map.put("title", title);
        map.put("content", content);
        return map;
    }

    public static NotificationCreationEntity toEntity(Map<String, String> map) {
        NotificationCreationEntity entity = new NotificationCreationEntity();
        entity.setSenderId(Long.parseLong(map.get("senderId")));
        entity.setReceiverId(Long.parseLong(map.get("receiverId")));
        entity.setTitle(map.get("title"));
        entity.setContent(map.get("content"));
        return entity;
    }
}
