package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.ShareRouteContainPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.ShareRouteContainPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareRouteContainPlaceService {
    @Autowired
    private ShareRouteContainPlaceRepository shareRouteContainPlaceRepository;

    /*
        根据 增加路线内容
     */
    public ShareRouteContainPlaceEntity add(ShareRouteContainPlaceEntity shareRouteContainPlaceEntity) {
        return shareRouteContainPlaceRepository.save(shareRouteContainPlaceEntity);
    }

    /*
        根据分享 ID 查找路线内容
     */
    public List<ShareRouteContainPlaceEntity> findByShareId(Integer shareId) {
        return shareRouteContainPlaceRepository.findShareRouteContainPlaceEntitiesByRouteShareId(shareId);
    }

    /*
        根据包含的地点查看路线
     */
    public List<ShareRouteContainPlaceEntity> findByPlaceId(Integer placeId) {
        return shareRouteContainPlaceRepository.findShareRouteContainPlaceEntitiesByRoutePlaceId(placeId);
    }

    /*
        修改路线的内容？
        但是该怎么修改呢？
        不改了，删的话直接按照share_id全删了就行了
     */
    public void deleteByShareId(Integer shareId) {
        shareRouteContainPlaceRepository.deleteShareRouteContainPlaceEntitiesByRouteShareId(shareId);
    }

}
