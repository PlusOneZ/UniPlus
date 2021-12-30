package cn.edu.tongji.uniplus.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Order
 *
 * @author 卓正一
 * @since 2021/12/26 2:49 AM
 */
@Document("order")
@Data
@NoArgsConstructor
public class Order {
    @MongoId
    private String id;
    // seller's id
    private Long sellerId;
    // buyer's id
    private Long buyerId;
    // total amount
    private Double totalPrice;
    // discount amount
    private Double discountAmount;
    /**
     * 0: unpaid
     * 1: paid
     * 2: on the way
     * 3: delivered
     * 4: commented
     * -1: canceled
     * -2: refunded
     *
     * @since 2021-12-26 3:08 AM
     */
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm : ss")
    private Date createdTime;

    @DateTimeFormat (pattern= "yyyy-MM-dd HH:mm : ss")
    private Date modifiedTime;

    // Goods id
    private Long goodsId;
    // Goods name
    private String goodsName;
    // thumbnail photo
    private String photoUrl;
    // buying amount
    private Integer amount;
    // unit price
    private Double price;

}
