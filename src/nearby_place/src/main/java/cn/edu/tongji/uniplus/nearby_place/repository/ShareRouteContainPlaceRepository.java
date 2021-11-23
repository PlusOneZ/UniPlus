package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.ShareRouteContainPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareRouteContainPlaceRepository extends JpaRepository<ShareRouteContainPlaceEntity,Integer> {
}
