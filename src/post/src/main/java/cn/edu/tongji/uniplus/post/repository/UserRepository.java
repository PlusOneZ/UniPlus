package cn.edu.tongji.uniplus.post.repository;

import cn.edu.tongji.uniplus.post.model.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PostUser, Long> {
}
