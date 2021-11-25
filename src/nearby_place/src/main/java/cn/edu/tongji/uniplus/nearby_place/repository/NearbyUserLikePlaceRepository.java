package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserLikePlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NearbyUserLikePlaceRepository extends JpaRepository<NearbyUserLikePlaceEntity, Long> {
    public List<NearbyUserLikePlaceEntity> findNearbyUserLikePlaceEntitiesByLikeUserId(Long userId);

    public NearbyUserLikePlaceEntity findNearbyUserLikePlaceEntityByLikeUserIdAndLikePlaceId(Long userId, Integer placeId);

    public void deleteNearbyUserLikePlaceEntityByLikeUserIdAndLikePlaceId(Long userId, Integer placeId);
}
