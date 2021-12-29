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
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Optional;

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
        // TODO: Add photo url
        OrderPlacementEntity entity = new OrderPlacementEntity(good, userId, amount, "");

        // redis

        // rabbit
        rabbitTemplate.convertAndSend(
                "orderPlacementDirect",
                "orderPlacementRouting",
                entity.toMap()
        );

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
}
