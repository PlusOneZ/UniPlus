package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceImgRepository extends JpaRepository<PlaceImgEntity,Integer> {
    public PlaceImgEntity findPlaceImgEntityByPlaceId(Integer Id);
}
