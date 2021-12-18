package cn.edu.tongji.uniplus.user.repository;

import cn.edu.tongji.uniplus.user.model.UserResidentInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserResidentInformationRepository
 *
 * @author 卓正一
 * @since 2021/12/10 8:58 PM
 */
public interface UserResidentInformationRepository extends JpaRepository<UserResidentInformationRepository, Long> {
    Optional<UserResidentInformationEntity> findByResidentId(String residentId);
}
