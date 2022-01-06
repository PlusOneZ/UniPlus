package cn.edu.tongji.uniplus.nearby_place.repository;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<NearbyUserEntity, Long> {

}
