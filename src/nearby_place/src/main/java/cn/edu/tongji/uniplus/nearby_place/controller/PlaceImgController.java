package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyPlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "附近地点图片")
@RestController
@RequestMapping("/api/v1/place-img")
public class PlaceImgController {
    @Autowired
    private NearbyPlaceService nearbyPlaceService;

    @ApiOperation("根据地点ID和图片顺序删除指定图片")
    @DeleteMapping("")
    public ResponseEntity<String> updatePlaceImg(@RequestParam("placeId") Integer placeId, @RequestParam("placeImgIndex") Integer placeImgIndex) {
        nearbyPlaceService.deletePlaceImgByPlaceIdAndPlaceImgIndex(placeId, placeImgIndex);
        return ResponseEntity.status(HttpStatus.OK).body("删除成功");
    }
}
