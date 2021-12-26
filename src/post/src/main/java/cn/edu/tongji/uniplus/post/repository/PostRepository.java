package cn.edu.tongji.uniplus.post.repository;

import cn.edu.tongji.uniplus.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    void deletePostByPostId(Long PostId);

    Post findByPostId(Long PostId);

    List<Post> findPostsByPostUserId(Long userId);

    List<Post> findPostsByPostAreaId(Integer areaId);
}
