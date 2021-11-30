package cn.edu.tongji.uniplus.good_information.repository;

import cn.edu.tongji.uniplus.good_information.model.GoodUserViewGoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodUserViewRepository extends JpaRepository<GoodUserViewGoodEntity,Long> {
    List<GoodUserViewGoodEntity> findGoodUserViewGoodEntitiesByViewGoodUserId(Long userId);

    List<GoodUserViewGoodEntity> findGoodUserViewGoodEntitiesByViewGoodId(Long goodId);

    @Query("select count(t) from GoodUserViewGoodEntity t where t.viewGoodUserId = ?1")
    Integer getViewTimesByViewGoodUserId(Long userId);

    @Query("select count(t) from GoodUserViewGoodEntity t where t.viewGoodId = ?1")
    Integer getViewTimesByViewGoodId(Long goodId);
}
