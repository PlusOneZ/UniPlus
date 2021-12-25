package cn.edu.tongji.uniplus.post.controller;

import cn.edu.tongji.uniplus.post.model.*;
import cn.edu.tongji.uniplus.post.service.PostService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Resource
    private PostService postService;

    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable("postId") Long postId) {
        return ResponseEntity.status(200).body(postService.getPostById(postId));
    }

    // 发帖
    @PostMapping()
    public ResponseEntity<String> pushNewPost(@RequestBody Post post) {
        postService.pushPost(post);
        return ResponseEntity.status(200).body("发帖成功");
    }

    // 回帖
    @PostMapping("/reply")
    public ResponseEntity<String> pushNewReply(@RequestBody PostReply postReply) {
        postService.pushReplyToPost(postReply);
        return ResponseEntity.status(200).body("回帖成功");
    }

    // 点赞帖子
    @PostMapping("/like/post")
    public ResponseEntity<String> pushNewPostLike(@RequestBody PostUserLikePost postUserLikePost) {
        postService.userLikePost(postUserLikePost);
        return ResponseEntity.status(200).body("点赞帖子成功");
    }

    // 点赞回复
    @PostMapping("/like/reply")
    public ResponseEntity<String> pushNewReplyLike(@RequestBody PostUserLikeReply postUserLikeReply) {
        postService.userLikeReply(postUserLikeReply);
        return ResponseEntity.status(200).body("点赞回复成功");
    }

    // 找用户发过的所有帖子
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostListByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(200).body(postService.getPostListByUserId(userId));
    }

    // 加载某帖子的所有回复
    @GetMapping("/reply/post/{postId}")
    public ResponseEntity<List<PostReply>> getReplyListByPostId(@PathVariable("postId") Long postId) {
        return ResponseEntity.status(200).body(postService.getPostReplyListByPostId(postId));
    }

    // 找用户发过的所有回复
    @GetMapping("/reply/user/{userId}")
    public ResponseEntity<List<PostReply>> getReplyListByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(200).body(postService.getReplyByUserId(userId));
    }

    // 找用户给所有帖子点过的赞
    @GetMapping("/like/post/{userId}")
    public ResponseEntity<List<PostUserLikePost>> getLikePostByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(200).body(postService.getUserLikePostListByUserId(userId));
    }

    // 找某用户给所有回复点过的赞
    @GetMapping("/like/reply/{userId}")
    public ResponseEntity<List<PostUserLikeReply>> getLikeReplyByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(200).body(postService.getUserLikeReplyListByUserId(userId));
    }

    // 删帖
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(200).body("删除成功");
    }

    // 删回复
    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity<String> deleteReply(@PathVariable("replyId") Long replyId) {
        postService.deleteReply(replyId);
        return ResponseEntity.status(200).body("删除成功");
    }

    // 删除帖子的点赞
    @DeleteMapping("/like/post")
    public ResponseEntity<String> deletePostLike(@RequestParam("user_id") Long userId, @RequestParam("post_id") Long postId) {
        postService.userDeleteLikePost(postId, userId);
        return ResponseEntity.status(200).body("删除帖子点赞成功");
    }

    // 删除回复的点赞
    @DeleteMapping("/like/reply")
    public ResponseEntity<String> deleteReplyLike(@RequestParam("user_id") Long userId, @RequestParam("reply_id") Long replyId) {
        postService.userDeleteLikeReply(replyId, userId);
        return ResponseEntity.status(200).body("删除回复点赞成功");
    }
}
