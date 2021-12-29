package cn.edu.tongji.uniplus.good_information.service.impl;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import cn.edu.tongji.uniplus.good_information.repository.GoodsRepository;
import cn.edu.tongji.uniplus.good_information.service.GoodsService;
import cn.edu.tongji.uniplus.good_information.service.exception.GoodsNotExistException;
import cn.edu.tongji.uniplus.good_information.util.OSSManageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * GoodsServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/29 10:30 PM
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsRepository goodsRepository;

    @Resource
    OSSManageUtils ossManageUtils;

    @Override
    public GoodGoodEntity getGoodById(Long id) {
        Optional<GoodGoodEntity> goods = goodsRepository.findById(id);
        if (goods.isPresent()) {
            return goods.get();
        } else {
            throw new GoodsNotExistException();
        }
    }

    @Override
    public List<GoodGoodEntity> getGoodsList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<GoodGoodEntity> goodPage = goodsRepository.findAllByOrderByGoodCreateTimeDesc(pageable);

        return goodPage.toList();
    }

    @Override
    public Boolean addGoods(
            String title,
            Double price,
            Double originalPrice,
            String unit,
            Integer stock,
            String desc,
            Integer classification
    ) {
        GoodGoodEntity good = new GoodGoodEntity();
        good.setGoodTitle(title);
        good.setGoodCurrentPrice(new BigDecimal(price));
        good.setGoodOriginalPrice(new BigDecimal(originalPrice));
        good.setGoodSellUnit(unit);
        good.setGoodStock(stock);
        good.setGoodDescription(desc);
        good.setGoodClassification(classification);

        try {
            goodsRepository.save(good);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
