package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserLikePlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userLikePlaceRepository extends JpaRepository<NearbyUserLikePlaceEntity,Long> {
}
