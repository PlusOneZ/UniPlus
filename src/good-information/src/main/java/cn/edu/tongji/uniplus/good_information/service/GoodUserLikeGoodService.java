package cn.edu.tongji.uniplus.good_information.service;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import cn.edu.tongji.uniplus.good_information.model.GoodUserLikeGoodEntity;
import cn.edu.tongji.uniplus.good_information.repository.GoodUserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GoodUserLikeGoodService {
    @Autowired
    private GoodUserLikeRepository goodUserLikeRepository;

    // 点赞
    public GoodUserLikeGoodEntity addUserLike(GoodUserLikeGoodEntity goodUserLikeGoodEntity) {
        return goodUserLikeRepository.save(goodUserLikeGoodEntity);
    }

    // 取消赞
    @Transactional
    public Optional<GoodUserLikeGoodEntity> deleteUserLike(Long userId, Long goodId) {
        return goodUserLikeRepository.deleteGoodUserLikeGoodEntityByLikeUserIdAndLikeGoodId(userId, goodId);
    }

    // 查看自己赞过的列表
    public List<GoodUserLikeGoodEntity> getUserLikeListById(Long userId) {
        return goodUserLikeRepository.findGoodUserLikeGoodEntitiesByLikeUserId(userId);
    }

    // 查看某个商品被哪些用户赞过
    public List<GoodUserLikeGoodEntity> getUserLikeListByGoodId(Long goodId) {
        return goodUserLikeRepository.findGoodUserLikeGoodEntitiesByLikeGoodId(goodId);
    }
}
