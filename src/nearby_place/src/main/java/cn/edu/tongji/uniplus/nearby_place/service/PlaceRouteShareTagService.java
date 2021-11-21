package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareTagEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceRouteShareTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceRouteShareTagService {
    @Autowired
    private PlaceRouteShareTagRepository placeRouteShareTagRepository;

    public void addPlaceRouteShareTag(PlaceRouteShareTagEntity placeRouteShareTagEntity){
        placeRouteShareTagRepository.save(placeRouteShareTagEntity);
    }
}
