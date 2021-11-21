package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserLikePlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.userLikePlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userLikePlaceService {
    @Autowired
    private userLikePlaceRepository userLikePlaceRepository;

    public void addUserLikePlace(NearbyUserLikePlaceEntity nearbyUserLikePlaceEntity) {
        userLikePlaceRepository.save(nearbyUserLikePlaceEntity);
    }
}
