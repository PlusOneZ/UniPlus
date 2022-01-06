package cn.edu.tongji.uniplus.order.payload;

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
public class OrderPlacementEntity {

    private Long goodsId;

    private String goodsName;

    private Integer purchaseAmount;
    // unit price
    private Double price;
    // thumbnail photo
    private String photoUrl;
    // seller's id
    private Long sellerId;
    // buyer's id
    private Long buyerId;
    // discount amount
    private Double discountAmount;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("goodsId", goodsId.toString());
        map.put("goodsName", goodsName);
        map.put("purchaseAmount", purchaseAmount.toString());
        map.put("price", price.toString());
        map.put("photoUrl", photoUrl);
        map.put("sellerId", sellerId.toString());
        map.put("buyerId", buyerId.toString());
        map.put("discountAmount", discountAmount.toString());
        return map;
    }

    public static OrderPlacementEntity toEntity(Map<String, String> map) {
        OrderPlacementEntity entity = new OrderPlacementEntity();
        entity.setGoodsId(Long.parseLong(map.get("goodsId")));
        entity.setGoodsName(map.get("goodsName"));
        entity.setPurchaseAmount(Integer.parseInt(map.get("purchaseAmount")));
        entity.setPrice(Double.parseDouble(map.get("price")));
        entity.setPhotoUrl(map.get("photoUrl"));
        entity.setSellerId(Long.parseLong(map.get("sellerId")));
        entity.setBuyerId(Long.parseLong(map.get("buyerId")));
        entity.setDiscountAmount(Double.parseDouble(map.get("discountAmount")));

        return entity;
    }
}
