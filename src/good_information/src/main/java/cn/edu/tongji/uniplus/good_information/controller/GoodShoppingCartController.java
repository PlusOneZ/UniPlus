package cn.edu.tongji.uniplus.good_information.controller;/*
    @Created by Jary-Li on 2021/11/30. All rights reserved.
    @Name: UniPlus
    @Description：
*/

import cn.edu.tongji.uniplus.good_information.model.GoodShoppingCartEntity;
import cn.edu.tongji.uniplus.good_information.service.GoodShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/good/cart")
public class GoodShoppingCartController {
    @Autowired
    private GoodShoppingCartService goodShoppingCartService;

    // 根据id查找
    @GetMapping("/{id}")
    public ResponseEntity<List<GoodShoppingCartEntity>> findCartByUserId(@PathVariable("id") Long userId) {
        if (goodShoppingCartService.getAllGoods(userId) != null)
            return ResponseEntity.status(200).body(goodShoppingCartService.getAllGoods(userId));
        else
            return ResponseEntity.status(204).body(null);
    }

    // 加入商品
    @PostMapping("")
    public ResponseEntity<String> addToCart(@RequestBody GoodShoppingCartEntity addItem) {
        goodShoppingCartService.addToCart(addItem);
        return ResponseEntity.status(200).body("添加成功");
    }

    // 修改记录
    // todo:部分字段为空的修改问题
    @PutMapping("/{userId}/{goodId}")
    public ResponseEntity<String> updateCart(@PathVariable("userId") Long userId, @PathVariable("goodId") Long goodId, @RequestBody GoodShoppingCartEntity afterUpdate) {
        goodShoppingCartService.updateGoodsAttr(userId, goodId, afterUpdate);
        return ResponseEntity.status(200).body("修改成功");
    }

    // 删除记录
    @DeleteMapping("/{userId}/{goodId}")
    public ResponseEntity<String> deleteFromCart(@PathVariable("userId") Long userId, @PathVariable("goodId") Long goodId) {
        goodShoppingCartService.deleteFromCart(userId, goodId);
        return ResponseEntity.status(200).body("删除成功");
    }
}
