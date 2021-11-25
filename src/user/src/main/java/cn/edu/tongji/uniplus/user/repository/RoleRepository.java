package cn.edu.tongji.uniplus.user.repository;

import cn.edu.tongji.uniplus.user.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RoleRepository
 *
 * @author 卓正一
 * @since 2021/11/24 8:42 PM
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
