package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRouteShareTagRepository extends JpaRepository<PlaceRouteShareTagEntity, Integer> {
    public List<PlaceRouteShareTagEntity> findPlaceRouteShareTagEntitiesByPlaceRouteShareId(Integer shareId);

    public List<PlaceRouteShareTagEntity> findPlaceRouteShareTagEntitiesByPlaceRouteShareTagContaining(String shareTag);
}
