package cn.edu.tongji.uniplus.good_information.service.impl;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import cn.edu.tongji.uniplus.good_information.payload.OrderPlacementEntity;
import cn.edu.tongji.uniplus.good_information.repository.GoodsRepository;
import cn.edu.tongji.uniplus.good_information.service.GoodsService;
import cn.edu.tongji.uniplus.good_information.service.PlaceOrderService;
import cn.edu.tongji.uniplus.good_information.service.exception.GoodsNotExistException;
import cn.edu.tongji.uniplus.good_information.util.RedisUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * PlaceOrderServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/30 3:57 AM
 */
@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Resource
    GoodsRepository goodRepository;

    @Resource
    RabbitTemplate rabbitTemplate;

    @Resource
    GoodsService goodsService;


    @Override
    public Boolean tryPlaceOrder(Long userId, Long goodId, int amount) {
        if (!checkGoodStock(goodId, amount)) {
            return false;
        }
        GoodGoodEntity good = goodRepository.findById(goodId).get();
        List<String> images = goodsService.getGoodsImages(goodId);
        OrderPlacementEntity entity = new OrderPlacementEntity(good, userId, amount, images.size() > 0 ? images.get(0) : "");

        // rabbit
        rabbitTemplate.convertAndSend(
                "orderPlacementDirect",
                "orderPlacementRouting",
                entity.toMap()
        );
        good.setGoodStock(good.getGoodStock() - amount);
        goodRepository.save(good);

        return true;
    }

    @Override
    public Boolean checkGoodStock(Long goodId, int amount) {
        Optional<GoodGoodEntity> good = goodRepository.findById(goodId);
        if (good.isPresent()) {
            return (good.get().getGoodStock() >= amount);
        } else {
            throw new GoodsNotExistException();
        }
    }

    @Override
    public void resumeStock(Long goodId, int amount) {
        Optional<GoodGoodEntity> goodOptional = goodRepository.findById(goodId);
        if (goodOptional.isPresent()) {
            GoodGoodEntity good = goodOptional.get();
            good.setGoodStock(good.getGoodStock() + amount);
            goodRepository.save(good);
        } else {
            throw new GoodsNotExistException();
        }
    }
}
