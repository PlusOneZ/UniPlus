package cn.edu.tongji.uniplus.good_information.service;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * GoodsService
 *
 * @author 卓正一
 * @since 2021/12/29 10:18 PM
 */
@Service
public interface GoodsService {

    GoodGoodEntity getGoodById(Long id);

    List<GoodGoodEntity> getGoodsList(int page, int pageSize);

    GoodGoodEntity addGoods(Long goodId,String title, BigDecimal price, BigDecimal originalPrice, String unit, Integer stock, String desc, Integer classification,Long ownerId);

    String uploadGoodImage(String base64, String fileName);

    Boolean uploadImageToDB(Long goodId,Integer goodImageIndex, String goodImageUrl);

    List<String> getGoodsImages(Long goodsId);
}
