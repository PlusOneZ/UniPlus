package cn.edu.tongji.uniplus.post.service;

import cn.edu.tongji.uniplus.post.model.Post;
import cn.edu.tongji.uniplus.post.model.PostReply;
import cn.edu.tongji.uniplus.post.model.PostUserLikePost;
import cn.edu.tongji.uniplus.post.model.PostUserLikeReply;
import cn.edu.tongji.uniplus.post.repository.PostUserLikePostRepository;
import cn.edu.tongji.uniplus.post.repository.PostReplyRepository;
import cn.edu.tongji.uniplus.post.repository.PostRepository;
import cn.edu.tongji.uniplus.post.repository.PostUserLikeReplyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/*
    一个服务就够用了
 */
@Service
public class PostService {
    @Resource
    private PostRepository postRepository;
    @Resource
    private PostReplyRepository postReplyRepository;
    @Resource
    private PostUserLikePostRepository postUserLikePostRepository;
    @Resource
    private PostUserLikeReplyRepository postUserLikeReplyRepository;

    // 发帖
    public void pushPost(Post post) {
        postRepository.save(post);
    }

    // 返回某用户所有的帖子
    public List<Post> getPostListByUserId(Long userId) {
        return postRepository.findPostsByPostUserId(userId);
    }

    // 删除指定ID的帖子
    @Transactional
    public void deletePost(Long postId) {
        postRepository.deletePostByPostId(postId);
    }

    // 加载某条帖子的所有回复？
    public List<PostReply> getPostReplyListByPostId(Long postId) {
        return postReplyRepository.findPostRepliesByReplyPostId(postId);
    }

    // 加载某条回复的所有回复
    public List<PostReply> getPostReplyListByReplyId(Long postId) {
        return postReplyRepository.findPostRepliesByParentReplyId(postId);
    }

    // 用户回复某条帖子
    public void pushReplyToPost(PostReply postReply) {
        postReplyRepository.save(postReply);
    }

    // 删除某条回复
    @Transactional
    public void deleteReply(Long replyId) {
        postReplyRepository.deletePostReplyByReplyId(replyId);
    }

    // 获取某用户的所有回复
    public List<PostReply> getReplyByUserId(Long userId) {
        return postReplyRepository.findPostRepliesByReplyUserId(userId);
    }

    // 用户点赞某条帖子
    public void userLikePost(PostUserLikePost post) {
        postUserLikePostRepository.save(post);
    }

    // 用户取消某条帖子的点赞
    @Transactional
    public void userDeleteLikePost(Long postId, Long userId) {
        postUserLikePostRepository.deletePostUserLikePostsByPostLikePostIdAndPostLikeUserId(postId, userId);
    }

    // 用户给回复点赞
    public void userLikeReply(PostUserLikeReply postUserLikeReply) {
        postUserLikeReplyRepository.save(postUserLikeReply);
    }

    // 用户取消回复点赞
    @Transactional
    public void userDeleteLikeReply(Long replyId, Long userId) {
        postUserLikeReplyRepository.deletePostUserLikeReplyByReplyLikeReplyIdAndReplyLikeUserId(replyId, userId);
    }

    //返回用户点赞的所有帖子
    public List<PostUserLikePost> getUserLikePostListByUserId(Long userId) {
        return postUserLikePostRepository.findPostUserLikePostsByPostLikeUserId(userId);
    }

    //返回某用户点赞的所有回复
    public List<PostUserLikeReply> getUserLikeReplyListByUserId(Long userId) {
        return postUserLikeReplyRepository.findPostUserLikePostsByReplyLikeReplyId(userId);
    }

    //根据ID找到帖子
    public Post getPostById(Long postId) {
        return postRepository.findByPostId(postId);
    }
}
