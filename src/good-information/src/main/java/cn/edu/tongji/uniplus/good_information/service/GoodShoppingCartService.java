package cn.edu.tongji.uniplus.good_information.service;
/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import cn.edu.tongji.uniplus.good_information.model.GoodShoppingCartEntity;
import cn.edu.tongji.uniplus.good_information.repository.GoodShoppingCartRepository;
import cn.edu.tongji.uniplus.good_information.tool.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GoodShoppingCartService {
    @Autowired
    private GoodShoppingCartRepository goodShoppingCartRepository;

    // 往购物车里加东西的服务
    public void addToCart(GoodShoppingCartEntity goodShoppingCartEntity) {
        goodShoppingCartRepository.save(goodShoppingCartEntity);
    }

    //从购物车里删东西 - 根据商品ID删
    @Transactional
    public void deleteFromCart(Long userId, Long goodId) {
        goodShoppingCartRepository.deleteGoodShoppingCartEntitiesByCartUserIdAndCartGoodId(userId, goodId);
    }

    // 查看某用户购物车里面所有的东西 - 通过用户ID
    //TODO:得这用户存在才能说后面的事啊？或者只要找不到就说找不到就行了，不管用户存在不存在
    public List<GoodShoppingCartEntity> getAllGoods(Long userId) {
        return goodShoppingCartRepository.findGoodShoppingCartEntitiesByCartUserId(userId);
    }

    // 修改某用户购物车里的某个ID的商品的属性（基本上只修改量）
    public GoodShoppingCartEntity updateGoodsAttr(Long userId, Long goodId, GoodShoppingCartEntity after) {
        GoodShoppingCartEntity before = goodShoppingCartRepository.findByCartUserIdAndCartGoodId(userId, goodId);
        if (before == null)
            return null;
        if (after != null) {
            JpaUtil.copyNotNullProperties(after, before);
        }
        return goodShoppingCartRepository.save(before);
    }
}
