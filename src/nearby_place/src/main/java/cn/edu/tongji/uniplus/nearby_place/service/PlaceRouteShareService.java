package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceRouteShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceRouteShareService {
    @Autowired
    private PlaceRouteShareRepository placeRouteShareRepository;

    public void addPlaceRouteShare(PlaceRouteShareEntity placeRouteShareEntity){
        placeRouteShareRepository.save(placeRouteShareEntity);
    }
}
