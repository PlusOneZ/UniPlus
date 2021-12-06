package cn.edu.tongji.uniplus.post.repository;

import cn.edu.tongji.uniplus.post.model.PostUserLikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostUserLikePostRepository extends JpaRepository<PostUserLikePost, Long> {

    // 某用户给某帖子点赞的记录
    PostUserLikePost findPostUserLikePostsByPostLikePostIdAndPostLikeUserId(Long postId, Long userId);

    // 某用户给某帖子取消点赞
    void deletePostUserLikePostsByPostLikePostIdAndPostLikeUserId(Long postId, Long userId);

    // 获取某用户所有的点赞记录
    List<PostUserLikePost> findPostUserLikePostsByPostLikeUserId(Long userId);
}
