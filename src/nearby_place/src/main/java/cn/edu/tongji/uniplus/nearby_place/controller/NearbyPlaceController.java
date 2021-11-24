package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.uniplus.nearby_place.dto.NearbyPlaceDTO;
import cn.edu.tongji.uniplus.nearby_place.dto.ResponseResult;
import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyPlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/nearby-place")

public class NearbyPlaceController {
    @Autowired
    private NearbyPlaceService nearbyPlaceService;
    /*
        一切的一切都要记得鉴权，如果不鉴权会很麻烦 qwq
        目前测试版没有鉴权
     */


    // TODO:怎么返回所有复合数据？

    /*
        添加 nearby_place
        测试通过 1/1
     */
    @PostMapping("")
    public ResponseEntity<String> addNearbyPlace(@RequestBody NearbyPlaceEntity nearbyPlaceEntity) {
        nearbyPlaceService.addNearbyPlace(nearbyPlaceEntity);
        return ResponseEntity.status(HttpStatus.OK).body("上传成功");
    }

    /*
        查找nearby_place 通过 ID 通过 Name
        测试通过 2/2
     */
    @GetMapping("/id/{placeId}")
    public ResponseEntity<NearbyPlaceDTO> getNearbyPlace(@PathVariable("placeId") Integer placeId) {
        NearbyPlaceDTO result = new NearbyPlaceDTO();
        result.setNearbyPlaceEntity(nearbyPlaceService.getNearbyPlaceById(placeId));
        result.setPlaceImgEntity(nearbyPlaceService.findPlaceImgByPlaceId(placeId));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping("/name/{placeName}")
    public ResponseEntity<NearbyPlaceDTO> getNearbyPlace(@PathVariable("placeName") String placeName) {
        NearbyPlaceDTO result = new NearbyPlaceDTO();
        result.setNearbyPlaceEntity(nearbyPlaceService.getNearbyPlaceByName(placeName));
        result.setPlaceImgEntity(nearbyPlaceService.findPlaceImgByPlaceId(nearbyPlaceService.getNearbyPlaceByName(placeName).getPlaceId()));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /*
        修改指定placeId的信息
        SpringJpa的原理是：只能根据主码获取到对象以后修改，所以回传的参数必须要有主码不然会报错；
        此外也没有其他的修改方式了。
     */
    @PutMapping("/id/{placeId}")
    public ResponseEntity<String> updateNearbyPlaceById(@PathVariable Integer placeId, @RequestBody NearbyPlaceEntity nearbyPlaceEntity) {
        nearbyPlaceService.updateNearbyPlaceById(placeId, nearbyPlaceEntity);
        return ResponseEntity.status(HttpStatus.OK).body("修改成功");
    }
}
