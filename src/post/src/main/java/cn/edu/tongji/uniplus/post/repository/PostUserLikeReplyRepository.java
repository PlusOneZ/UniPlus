package cn.edu.tongji.uniplus.post.repository;

import cn.edu.tongji.uniplus.post.model.PostUserLikeReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostUserLikeReplyRepository extends JpaRepository<PostUserLikeReply, Long> {
    // 获取某回复所有点赞的用户
    List<PostUserLikeReply> findPostUserLikeReplyByReplyLikeReplyId(Long replyId);

    // 某用户给某回复点赞的记录
    PostUserLikeReply findPostUserLikeReplyByReplyLikeReplyIdAndReplyLikeUserId(Long replyId, Long userId);

    // 某用户给某回复取消点赞
    void deletePostUserLikeReplyByReplyLikeReplyIdAndReplyLikeUserId(Long replyId, Long userId);

    // 获取某用户所有点赞回复的记录
    List<PostUserLikeReply> findPostUserLikePostsByReplyLikeReplyId(Long userId);
}
