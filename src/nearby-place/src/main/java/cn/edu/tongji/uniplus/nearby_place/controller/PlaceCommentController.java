package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceCommentEntity;
import cn.edu.tongji.uniplus.nearby_place.service.PlaceCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    模块和注释的事居然能解决了
 */
@Api(tags = "用户评论")
@RestController
@RequestMapping("/api/v1/place")
public class PlaceCommentController {
    @Autowired
    private PlaceCommentService placeCommentService;


    @GetMapping("")
    public ResponseEntity<List<PlaceCommentEntity>> getPlaceComment() {
        return ResponseEntity.status(200).body(placeCommentService.getAll());
    }

    @ApiOperation("根据ID获取指定用户的所有评论")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaceCommentEntity>> getPlaceCommentByUserId(@PathVariable("userId") Long userId) {
        if (placeCommentService.findAllByUserId(userId) != null)
            return ResponseEntity.status(HttpStatus.OK).body(placeCommentService.findAllByUserId(userId));
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @ApiOperation("添加评论")
    @PostMapping("")
    public ResponseEntity<String> addPlaceComment(@RequestBody PlaceCommentEntity placeComment) {
        placeCommentService.add(placeComment);
        return ResponseEntity.status(HttpStatus.OK).body("添加成功");
    }

    @ApiOperation("根据ID删除指定的评论")
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<String> deletePlaceCommentById(@PathVariable("commentId") Long commentId) {
        placeCommentService.delete(commentId);
        return ResponseEntity.status(HttpStatus.OK).body("删除成功");
    }
}
