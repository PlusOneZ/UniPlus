package cn.edu.tongji.uniplus.good_information.service;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import cn.edu.tongji.uniplus.good_information.model.GoodUserViewGoodEntity;
import cn.edu.tongji.uniplus.good_information.repository.GoodUserViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodUserViewService {
    @Autowired
    private GoodUserViewRepository goodUserViewRepository;
    //应该是不用修改的，这个是既定事实的数据
    // todo:不过也不好说，浏览记录肯定是可以删除的

    // 添加浏览记录
    public GoodUserViewGoodEntity addViewRecord(GoodUserViewGoodEntity goodUserViewGoodEntity) {
        return goodUserViewRepository.save(goodUserViewGoodEntity);
    }

    // 查看浏览记录 用户id
    public List<GoodUserViewGoodEntity> getViewListByUserId(Long userId) {
        return goodUserViewRepository.findGoodUserViewGoodEntitiesByViewGoodUserId(userId);
    }

    //查看浏览记录 物品id
    public List<GoodUserViewGoodEntity> getViewListByUserGoodId(Long goodId) {
        return goodUserViewRepository.findGoodUserViewGoodEntitiesByViewGoodId(goodId);
    }

    // 统计总浏览量？可以用个count试试
    public Integer getViewTimesByUserId(Long userId) {
        return goodUserViewRepository.getViewTimesByViewGoodUserId(userId);
    }

    //统计某件物品的浏览量
    public Integer getViewTimesByGoodId(Long goodId) {
        return goodUserViewRepository.getViewTimesByViewGoodId(goodId);
    }
}
