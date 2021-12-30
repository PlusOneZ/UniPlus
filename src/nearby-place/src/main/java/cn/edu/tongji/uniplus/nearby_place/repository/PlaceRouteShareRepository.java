package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRouteShareRepository extends JpaRepository<PlaceRouteShareEntity, Integer> {
    public List<PlaceRouteShareEntity> findPlaceRouteShareEntitiesByRoutePublisherId(Long userId);

    public List<PlaceRouteShareEntity> findPlaceRouteShareEntitiesByShareRouteTitleContaining(String partTitle);

    public PlaceRouteShareEntity findPlaceRouteShareEntityByRouteShareId(Integer shareId);

    public PlaceRouteShareEntity deletePlaceRouteShareEntityByRouteShareId(Integer shareId);
}
