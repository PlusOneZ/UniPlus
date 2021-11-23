package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPositionEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.NearbyPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NearbyPositionService {
    @Autowired
    private NearbyPositionRepository nearbyPositionRepository;

    public void addNearbyPositionRepository(NearbyPositionEntity nearbyPositionEntity) {
        nearbyPositionRepository.save(nearbyPositionEntity);
    }
}
