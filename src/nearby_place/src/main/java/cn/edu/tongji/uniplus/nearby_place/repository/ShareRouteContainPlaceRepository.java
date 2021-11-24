package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.ShareRouteContainPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareRouteContainPlaceRepository extends JpaRepository<ShareRouteContainPlaceEntity, Integer> {
    public List<ShareRouteContainPlaceEntity> findShareRouteContainPlaceEntitiesByRouteShareId(Integer shareId);

    public List<ShareRouteContainPlaceEntity> findShareRouteContainPlaceEntitiesByRoutePlaceId(Integer placeId);

    public void deleteShareRouteContainPlaceEntitiesByRouteShareId(Integer placeId);
}
