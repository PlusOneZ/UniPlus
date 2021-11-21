package cn.edu.tongji.uniplus.user.repository;

import cn.edu.tongji.uniplus.user.model.uniplusRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface uniplusRoleRepository extends JpaRepository<uniplusRole, Integer> {
    public uniplusRole findByRoleId(Integer roleId);
}
