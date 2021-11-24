package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceCommentEntity;
import cn.edu.tongji.uniplus.nearby_place.service.PlaceCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/place-comment")
public class PlaceCommentController {
    @Autowired
    private PlaceCommentService placeCommentService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaceCommentEntity>> getPlaceCommentByUserId(@PathVariable("userId") Long userId) {
        if (placeCommentService.findAllByUserId(userId) != null)
            return ResponseEntity.status(HttpStatus.OK).body(placeCommentService.findAllByUserId(userId));
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<PlaceCommentEntity>> getPlaceCommentByPlaceId(@PathVariable("placeId") Integer placeId) {
        if (placeCommentService.findAllByPlaceId(placeId) != null)
            return ResponseEntity.status(HttpStatus.OK).body(placeCommentService.findAllByPlaceId(placeId));
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("")
    public ResponseEntity<String> addPlaceComment(@RequestBody PlaceCommentEntity placeComment) {
        placeCommentService.add(placeComment);
        return ResponseEntity.status(HttpStatus.OK).body("添加成功");
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<String> deletePlaceCommentById(@PathVariable("commentId") Long commentId) {
        placeCommentService.delete(commentId);
        return ResponseEntity.status(HttpStatus.OK).body("删除成功");
    }
}
