package cn.edu.tongji.uniplus.good_information.service;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import org.springframework.stereotype.Service;

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

    Boolean addGoods(String title, Double price, Double originalPrice, String unit, Integer stock, String desc, Integer classification);

    List<String> getGoodsImages(Long goodsId);
}
