package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserPublishPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.NearbyUserPublishPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NearbyUserPublishPlaceService {
    @Autowired
    private NearbyUserPublishPlaceRepository nearbyUserPublishPlaceRepository;

}
