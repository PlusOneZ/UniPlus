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

    Boolean addGoods(String title, BigDecimal price, BigDecimal originalPrice, String unit, Integer stock, String desc, Integer classification);

    String uploadGoodImage(String base64, String fileName);



    List<String> getGoodsImages(Long goodsId);
}
