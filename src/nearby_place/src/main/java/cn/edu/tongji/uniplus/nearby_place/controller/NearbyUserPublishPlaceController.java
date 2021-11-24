package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserLikePlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserPublishPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyUserPublishPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nearby-user-publish-place")
public class NearbyUserPublishPlaceController {
    @Autowired
    private NearbyUserPublishPlaceService nearbyUserPublishPlaceService;

    @GetMapping("/id/{userId}")
    public ResponseEntity<List<NearbyUserPublishPlaceEntity>> getNearbyUserPublishPlaceByUserId(@PathVariable("userId") Long userId) {
        List<NearbyUserPublishPlaceEntity> result = nearbyUserPublishPlaceService.getAllByUserId(userId);
        if (result == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("")
    public ResponseEntity<String> addNearbyUserPublishPlace(@RequestBody NearbyUserPublishPlaceEntity nearbyUserPublishPlaceEntity) {
        nearbyUserPublishPlaceService.add(nearbyUserPublishPlaceEntity);
        return ResponseEntity.status(HttpStatus.OK).body("添加成功");
    }
}
