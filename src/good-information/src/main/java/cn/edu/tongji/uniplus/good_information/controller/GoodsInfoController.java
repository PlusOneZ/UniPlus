package cn.edu.tongji.uniplus.good_information.controller;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import cn.edu.tongji.uniplus.good_information.service.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * GoodsInfoController
 *
 * @author 卓正一s
 * @since 2021/12/29 10:41 PM
 */
@RestController
@RequestMapping("/api/v1/good")
public class GoodsInfoController {

    @Resource
    GoodsService goodsService;

    @GetMapping("{id}")
    public ResponseEntity<GoodGoodEntity> getGoodInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(goodsService.getGoodById(id));
    }

    @GetMapping("list")
    public ResponseEntity<List<GoodGoodEntity>> getListPage(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(goodsService.getGoodsList(page, size));
    }

    // 增加 post api
    @PostMapping("")
    public ResponseEntity<Object> publishGood(@RequestBody GoodGoodEntity good) {
        return ResponseEntity.status(200).body(goodsService.addGoods(good.getGoodTitle(), good.getGoodCurrentPrice(), good.getGoodOriginalPrice(),
                good.getGoodSellUnit(), good.getGoodStock(), good.getGoodDescription(), good.getGoodClassification()));
    }

    @PostMapping("image")
    public ResponseEntity<Object> uploadImage(@RequestBody String base64) {
        return ResponseEntity.status(200).body(goodsService.uploadGoodImage(base64, UUID.randomUUID().toString().replaceAll("-", "")));
    }
}
