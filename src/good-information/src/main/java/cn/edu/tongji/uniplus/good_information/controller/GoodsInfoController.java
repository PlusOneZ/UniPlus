package cn.edu.tongji.uniplus.good_information.controller;

import cn.edu.tongji.uniplus.good_information.model.GoodGoodEntity;
import cn.edu.tongji.uniplus.good_information.model.GoodImageEntity;
import cn.edu.tongji.uniplus.good_information.service.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Base64;
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
        return ResponseEntity.status(200).body(goodsService.addGoods(good.getGoodId(), good.getGoodTitle(), good.getGoodCurrentPrice(), good.getGoodOriginalPrice(),
                good.getGoodSellUnit(), good.getGoodStock(), good.getGoodDescription(), good.getGoodClassification(), good.getGoodOwnerId()));
    }

    @PostMapping("ali/image")
    public ResponseEntity<Object> uploadImage(@RequestBody String base64) {
        base64 = base64.substring(1, base64.length() - 1);
        return ResponseEntity.status(200).body(goodsService.uploadGoodImage(base64, UUID.randomUUID().toString().replaceAll("-", "")));
    }

    @PostMapping("image")
    public ResponseEntity<Object> uploadImageToDB(@RequestBody GoodImageEntity goodImageEntity) {
        return ResponseEntity.status(200).body(goodsService.uploadImageToDB(goodImageEntity.getGoodId(), goodImageEntity.getGoodImageIndex(), goodImageEntity.getGoodImageUrl()));
    }
}

