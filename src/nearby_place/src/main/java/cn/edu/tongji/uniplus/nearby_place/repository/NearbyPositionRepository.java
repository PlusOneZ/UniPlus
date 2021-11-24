package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NearbyPositionRepository extends JpaRepository<NearbyPositionEntity, Integer> {
    public NearbyPositionEntity findNearbyPositionEntityByPositionId(int Id);
    public NearbyPositionEntity findNearbyPositionEntityByPositionName(String Name);
    public NearbyPositionEntity deleteNearbyPositionEntityByPositionId(int Id);
    public NearbyPositionEntity deleteNearbyPositionEntityByPositionName(String Name);
}
