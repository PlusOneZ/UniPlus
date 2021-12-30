package cn.edu.tongji.uniplus.good_information.service.impl;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import cn.edu.tongji.uniplus.good_information.model.GoodImageEntity;
import cn.edu.tongji.uniplus.good_information.repository.GoodImageRepository;
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

    @Resource
    GoodImageRepository goodImageRepository;

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
    public GoodGoodEntity addGoods(
            Long goodId,
            String title,
            BigDecimal price,
            BigDecimal originalPrice,
            String unit,
            Integer stock,
            String desc,
            Integer classification,
            Long ownerId
    ) {
        GoodGoodEntity good = new GoodGoodEntity();
        good.setGoodId(goodId);
        good.setGoodTitle(title);
        good.setGoodCurrentPrice(price);
        good.setGoodOriginalPrice(originalPrice);
        good.setGoodSellUnit(unit);
        good.setGoodStock(stock);
        good.setGoodDescription(desc);
        good.setGoodClassification(classification);
        good.setGoodOwnerId(ownerId);

        try {
            return goodsRepository.save(good);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String uploadGoodImage(String base64, String fileName) {
        try {
            return ossManageUtils.base64UploadFile(base64, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public Boolean uploadImageToDB(Long goodId, Integer goodImageIndex, String goodImageUrl) {
        GoodImageEntity image = new GoodImageEntity();
        image.setGoodId(goodId);
        image.setGoodId(goodImageIndex);
        image.setGoodImageUrl(goodImageUrl);
        try {
            goodImageRepository.save(image);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
