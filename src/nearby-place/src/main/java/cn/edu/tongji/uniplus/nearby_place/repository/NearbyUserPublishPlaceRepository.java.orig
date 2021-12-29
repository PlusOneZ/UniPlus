package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserPublishPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NearbyUserPublishPlaceRepository extends JpaRepository<NearbyUserPublishPlaceEntity,Integer> {
    public List<NearbyUserPublishPlaceEntity> findNearbyUserPublishPlaceEntitiesByPublishUserId(Long userId);
}
