package cn.edu.tongji.uniplus.post.repository;

import cn.edu.tongji.uniplus.post.model.Post;
import cn.edu.tongji.uniplus.post.model.PostReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostReplyRepository extends JpaRepository<PostReply, Long> {
    List<PostReply> findPostRepliesByParentReplyId(Long parentReplyId);

    PostReply deletePostReplyByParentReplyId(Long replyId);

    List<PostReply> findPostRepliesByReplyUserId(Long userId);
}
