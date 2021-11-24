package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/place-img")
public class PlaceImgController {
    @Autowired
    private NearbyPlaceService nearbyPlaceService;

    @DeleteMapping("")
    public ResponseEntity<String> updatePlaceImg(@RequestParam("placeId") Integer placeId, @RequestParam("placeImgIndex") Integer placeImgIndex) {
        nearbyPlaceService.deletePlaceImgByPlaceIdAndPlaceImgIndex(placeId, placeImgIndex);
        return ResponseEntity.status(HttpStatus.OK).body("删除成功");
    }
}
