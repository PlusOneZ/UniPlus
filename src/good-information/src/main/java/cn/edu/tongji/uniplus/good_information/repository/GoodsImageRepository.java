package cn.edu.tongji.uniplus.good_information.repository;

import cn.edu.tongji.uniplus.good_information.model.GoodImageEntity;
import cn.edu.tongji.uniplus.good_information.model.GoodImageEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsImageRepository extends JpaRepository<GoodImageEntity, GoodImageEntityPK> {

    List<GoodImageEntity> findAllByGoodIdOrderByGoodImageIndex(Long id);

}
