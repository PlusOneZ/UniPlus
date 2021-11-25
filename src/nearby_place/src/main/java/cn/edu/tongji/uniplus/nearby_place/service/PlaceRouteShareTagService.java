package cn.edu.tongji.uniplus.nearby_place.service;


import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareTagEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceRouteShareTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceRouteShareTagService {
    @Autowired
    private PlaceRouteShareTagRepository placeRouteShareTagRepository;

    /*
        给某个地点加 tag
     */

    public PlaceRouteShareTagEntity add(PlaceRouteShareTagEntity placeRouteShareTagEntity) {
        return placeRouteShareTagRepository.save(placeRouteShareTagEntity);
    }

    /*
        给某个地点查 tag
        根据某个tag查地点
     */

    public List<PlaceRouteShareTagEntity> findByShareId(Integer shareId) {
        return placeRouteShareTagRepository.findPlaceRouteShareTagEntitiesByPlaceRouteShareId(shareId);
    }

    public List<PlaceRouteShareTagEntity> findByTagName(String tagName) {
        return placeRouteShareTagRepository.findPlaceRouteShareTagEntitiesByPlaceRouteShareTagContaining(tagName);
    }

    /*
        考虑一下其他功能
        修改和删除貌似是不需要加的，那就不加了
     */
}
