package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceCommentEntity;
import cn.edu.tongji.uniplus.nearby_place.service.PlaceCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/place_comment")
public class PlaceCommentController {
    @Autowired
    private PlaceCommentService placeCommentService;

    // POST方法 - 增加评论，由前端进行增加
    @PostMapping("/add")
    public ResponseEntity<String> addPlaceComment(@RequestBody PlaceCommentEntity placeComment) {
        placeCommentService.addComment(placeComment);
        return ResponseEntity.ok("评论成功");
    }
}
