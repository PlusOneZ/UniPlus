package cn.edu.tongji.uniplus.good_information.repository;

import cn.edu.tongji.uniplus.good_information.model.GoodUserEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

@DynamicInsert
@DynamicUpdate
public interface GoodUserRepository extends JpaRepository<GoodUserEntity, Long> {
}
