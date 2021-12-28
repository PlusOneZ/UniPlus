package cn.edu.tongji.uniplus.good_information.controller;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import cn.edu.tongji.uniplus.good_information.model.GoodUserLikeGoodEntity;
import cn.edu.tongji.uniplus.good_information.service.GoodUserLikeGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/good/like")
public class GoodUserLikeController {
    @Autowired
    private GoodUserLikeGoodService goodUserLikeGoodService;

    // 点赞
    @PostMapping("")
    public ResponseEntity<String> addUserLike(@RequestBody GoodUserLikeGoodEntity goodUserLikeGoodEntity) {
        goodUserLikeGoodService.addUserLike(goodUserLikeGoodEntity);
        return ResponseEntity.status(200).body("点赞成功");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GoodUserLikeGoodEntity>> getUserLikeListByUserId(@PathVariable("userId") Long userId) {
        if (goodUserLikeGoodService.getUserLikeListById(userId) != null)
            return ResponseEntity.status(200).body(goodUserLikeGoodService.getUserLikeListById(userId));
        else
            return ResponseEntity.status(404).body(null);
    }

    @GetMapping("/good/{goodId}")
    public ResponseEntity<List<GoodUserLikeGoodEntity>> getUserLikeListByGoodId(@PathVariable("goodId") Long goodId) {
        if (goodUserLikeGoodService.getUserLikeListByGoodId(goodId) != null)
            return ResponseEntity.status(200).body(goodUserLikeGoodService.getUserLikeListByGoodId(goodId));
        else
            return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/{userId}/{goodId}")
    public ResponseEntity<String> deleteUserLike(@PathVariable("userId") Long userId, @PathVariable("goodId") Long goodId) {
        goodUserLikeGoodService.deleteUserLike(userId, goodId);
        return ResponseEntity.status(200).body("删除成功");
    }
}
