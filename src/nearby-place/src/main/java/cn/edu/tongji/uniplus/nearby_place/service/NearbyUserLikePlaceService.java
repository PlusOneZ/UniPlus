package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserLikePlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.NearbyUserLikePlaceRepository;
import cn.edu.tongji.uniplus.nearby_place.tool.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NearbyUserLikePlaceService {
    @Autowired
    private NearbyUserLikePlaceRepository userLikePlaceRepository;

    /*
        添加某个用户喜欢的地点
     */
    public NearbyUserLikePlaceEntity addNearbyUserLikePlaceEntity(NearbyUserLikePlaceEntity nearbyUserLikePlaceEntity) {
        return userLikePlaceRepository.save(nearbyUserLikePlaceEntity);
    }

    /*
        查找某个用户喜欢的地点
        TODO:查找的函数在 DAO 层里构建好了，记得实现完
     */
    public List<NearbyUserLikePlaceEntity> getNearbyUserLikePlaceEntityByUserId(Long userId) {
        return userLikePlaceRepository.findNearbyUserLikePlaceEntitiesByLikeUserId(userId);
    }

    /*
        修改某个用户喜欢的地点
        从业务逻辑上来说到底需不需要修改？要修改的话，是不是直接删了再修改就行了？
        不然直接修改的话，这个多值属性也属于是不太好修改
        确定了，删了再自己去加
     */
    @Transactional
    public void deleteNearbyUserLikePlaceEntity(Long userId, Integer placeId) {
        userLikePlaceRepository.deleteNearbyUserLikePlaceEntityByLikeUserIdAndLikePlaceId(userId, placeId);
    }
}
