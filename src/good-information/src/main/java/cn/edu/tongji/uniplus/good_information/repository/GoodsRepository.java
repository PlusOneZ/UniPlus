package cn.edu.tongji.uniplus.good_information.repository;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@DynamicInsert
@DynamicUpdate
public interface GoodsRepository extends JpaRepository<GoodGoodEntity, Long> {

    Page<GoodGoodEntity> findAllByOrderByGoodCreateTimeDesc(Pageable pageable);

}
