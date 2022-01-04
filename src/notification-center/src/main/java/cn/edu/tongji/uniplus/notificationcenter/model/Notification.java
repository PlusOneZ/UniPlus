package cn.edu.tongji.uniplus.notificationcenter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Notification
 *
 * @author 卓正一
 * @since 2021/12/26 2:49 AM
 */
@Document("order")
@Data
@NoArgsConstructor
public class Notification {
    @MongoId
    private String id;
    // seller's id
    private Long senderId;
    // buyer's id
    private Long receiverId;
    // total amount
    private String title;
    // discount amount
    private String content;
    /**
     * 0: unsend
     * 1: unread
     * 2: read
     *
     * @since 2021-12-26 3:08 AM
     */
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm : ss")
    private Date createdTime;

    @DateTimeFormat (pattern= "yyyy-MM-dd HH:mm : ss")
    private Date readTime;
}
