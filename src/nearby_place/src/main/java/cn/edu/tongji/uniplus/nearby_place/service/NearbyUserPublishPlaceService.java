package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserPublishPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.NearbyUserPublishPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NearbyUserPublishPlaceService {
    @Autowired
    private NearbyUserPublishPlaceRepository nearbyUserPublishPlaceRepository;

    /*
        增加 NearbyUserPublishPlaceRepository的记录
     */
    public NearbyUserPublishPlaceEntity add(NearbyUserPublishPlaceEntity nearbyUserPublishPlaceEntity) {
        return nearbyUserPublishPlaceRepository.save(nearbyUserPublishPlaceEntity);
    }

    /*
        查找 指定 NearbyUserPublishPlaceRepository的记录
     */
    public List<NearbyUserPublishPlaceEntity> getAllByUserId(Long userId) {
        return nearbyUserPublishPlaceRepository.findNearbyUserPublishPlaceEntitiesByPublishUserId(userId);
    }
    /*
        需要修改吗？用户只要上传了记录就应该保存，不应该删除吧？
        如果要删除的话，只删记录而不删除是不是不太合理？
        TODO:值得商榷
     */
}
