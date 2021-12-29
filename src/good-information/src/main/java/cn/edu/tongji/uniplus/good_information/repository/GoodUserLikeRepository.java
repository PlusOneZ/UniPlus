package cn.edu.tongji.uniplus.good_information.repository;

import cn.edu.tongji.uniplus.good_information.model.GoodUserLikeGoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodUserLikeRepository extends JpaRepository<GoodUserLikeGoodEntity, Long> {
    Optional<GoodUserLikeGoodEntity> deleteGoodUserLikeGoodEntityByLikeUserIdAndLikeGoodId(Long userId, Long goodId);

    List<GoodUserLikeGoodEntity> findGoodUserLikeGoodEntitiesByLikeUserId(Long userId);

    List<GoodUserLikeGoodEntity> findGoodUserLikeGoodEntitiesByLikeGoodId(Long goodId);
}
