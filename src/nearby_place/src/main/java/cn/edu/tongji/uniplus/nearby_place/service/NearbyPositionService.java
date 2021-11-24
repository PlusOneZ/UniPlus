package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.NearbyPositionEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.NearbyPositionRepository;
import cn.edu.tongji.uniplus.nearby_place.tool.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NearbyPositionService {
    @Autowired
    private NearbyPositionRepository nearbyPositionRepository;

    /*
        增加 NearbyPosition
     */
    public NearbyPositionEntity addNearbyPositionEntity(NearbyPositionEntity nearbyPositionEntity) {
        return nearbyPositionRepository.save(nearbyPositionEntity);
    }

    /*
        根据 ID 地名 查找 NearbyPosition
     */
    public NearbyPositionEntity getNearbyPositionEntityById(int nearbyPositionEntityId) {
        return nearbyPositionRepository.findNearbyPositionEntityByPositionId(nearbyPositionEntityId);
    }

    public NearbyPositionEntity getNearbyPositionByName(String nearbyPositionName) {
        return nearbyPositionRepository.findNearbyPositionEntityByPositionName(nearbyPositionName);
    }

    /*
        修改指定 ID、地名的 NearbyPosition 信息
     */
    public NearbyPositionEntity updateNearbyPositionById(int nearbyPositionEntityId, NearbyPositionEntity after) {
        NearbyPositionEntity before = nearbyPositionRepository.findNearbyPositionEntityByPositionId(nearbyPositionEntityId);
        if (before == null)
            return null;
        if (after != null) {
            JpaUtil.copyNotNullProperties(after, before);
        }
        return nearbyPositionRepository.save(before);
    }

    public NearbyPositionEntity updateNearbyPositionByName(String nearbyPositionEntityName, NearbyPositionEntity after) {
        NearbyPositionEntity before = nearbyPositionRepository.findNearbyPositionEntityByPositionName(nearbyPositionEntityName);
        if (before == null)
            return null;
        if (after != null) {
            JpaUtil.copyNotNullProperties(after, before);
        }
        return nearbyPositionRepository.save(before);
    }

    /*
        删除指定ID、地名的 NearbyPosition 信息，不过这个还没测试过，不知道会有什么美妙的效果
     */
    public NearbyPositionEntity deleteNearbyPositionById(int nearbyPositionEntityId) {
        return nearbyPositionRepository.deleteNearbyPositionEntityByPositionId(nearbyPositionEntityId);
    }

    public NearbyPositionEntity deleteNearbyPositionByName(String nearbyPositionEntityName) {
        return nearbyPositionRepository.deleteNearbyPositionEntityByPositionName(nearbyPositionEntityName);
    }
}
