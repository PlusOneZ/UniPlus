package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceImgRepository extends JpaRepository<PlaceImgEntity, Integer> {
    public List<PlaceImgEntity> findPlaceImgEntitiesByPlaceId(Integer placeId);
    public void deletePlaceImgEntityByPlaceIdAndPlaceImgIndex(Integer placeId,Integer placeImgIndex);
}
