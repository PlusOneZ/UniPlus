package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NearbyPlaceRepository extends JpaRepository<NearbyPlaceEntity,Integer> {
    public NearbyPlaceEntity findNearbyPlaceEntityByPlaceId(Integer Id);
    public NearbyPlaceEntity findNearbyPlaceEntityByPlaceName(String Name);
}
