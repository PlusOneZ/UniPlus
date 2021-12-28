package cn.edu.tongji.uniplus.order.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * OrderDetail
 *
 * @author 卓正一
 * @since 2021/12/26 3:16 AM
 */
@Data
public class OrderDetail {
    // Goods id
    private Long goodsId;
    // Goods name
    private String goodsName;
    // thumbnail photo
    private String photo;
    // buying amount
    private Integer amount;
    // unit price
    private Double price;
    // total price
    private Double totalPrice;
    // created time
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
}
