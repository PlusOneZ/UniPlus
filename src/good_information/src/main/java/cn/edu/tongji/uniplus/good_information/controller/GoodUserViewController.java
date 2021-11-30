package cn.edu.tongji.uniplus.good_information.controller;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import cn.edu.tongji.uniplus.good_information.model.GoodUserViewGoodEntity;
import cn.edu.tongji.uniplus.good_information.service.GoodUserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/good/view")
public class GoodUserViewController {
    @Autowired
    private GoodUserViewService goodUserViewService;

    @PostMapping("")
    public ResponseEntity<String> addViewRecord(@RequestBody GoodUserViewGoodEntity goodUserViewGoodEntity) {
        goodUserViewService.addViewRecord(goodUserViewGoodEntity);
        return ResponseEntity.status(200).body("添加成功");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GoodUserViewGoodEntity>> getViewListByUserId(@PathVariable("userId") Long userId) {
        if (goodUserViewService.getViewListByUserId(userId) != null)
            return ResponseEntity.status(200).body(goodUserViewService.getViewListByUserId(userId));
        else
            return ResponseEntity.status(404).body(null);
    }

    @GetMapping("/good/{goodId}")
    public ResponseEntity<List<GoodUserViewGoodEntity>> getViewListByGoodId(@PathVariable("goodId") Long goodId) {
        if (goodUserViewService.getViewListByUserGoodId(goodId) != null)
            return ResponseEntity.status(200).body(goodUserViewService.getViewListByUserGoodId(goodId));
        else
            return ResponseEntity.status(404).body(null);
    }

    @GetMapping("/count/user/{userId}")
    public ResponseEntity<Integer> getViewTimesByUserId(@PathVariable("userId") Long userId) {
        if (goodUserViewService.getViewTimesByUserId(userId) != null)
            return ResponseEntity.status(200).body(goodUserViewService.getViewTimesByUserId(userId));
        else
            return ResponseEntity.status(404).body(null);
    }

    @GetMapping("/count/good/{goodId}")
    public ResponseEntity<Integer> getViewTimesByGoodId(@PathVariable("goodId") Long goodId) {
        if (goodUserViewService.getViewTimesByGoodId(goodId) != null)
            return ResponseEntity.status(200).body(goodUserViewService.getViewTimesByGoodId(goodId));
        else
            return ResponseEntity.status(404).body(null);
    }
}
