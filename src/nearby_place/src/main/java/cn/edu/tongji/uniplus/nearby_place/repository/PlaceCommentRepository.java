package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceCommentRepository extends JpaRepository<PlaceCommentEntity, Long> {
    public List<PlaceCommentEntity> findPlaceCommentEntitiesByPlaceCommentUser(Long userId);

    public List<PlaceCommentEntity> findPlaceCommentEntitiesByPlaceCommentOnPlace(Integer placeId);

    public List<PlaceCommentEntity> findPlaceCommentEntitiesByCommentRatingGreaterThanEqual(Integer commentRate);

    public List<PlaceCommentEntity> deletePlaceCommentEntityByPlaceCommentUser(Long userId);

    public void deletePlaceCommentEntityByPlaceCommentId(Long commentId);
}
