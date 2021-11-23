package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserPublishPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyUserPublishPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nearby_user_publish_place")
public class NearbyUserPublishPlaceController {
    @Autowired
    private NearbyUserPublishPlaceService nearbyUserPublishPlaceService;

    @PostMapping("/add")
    public ResponseEntity<String> addNearbyUserPublishPlaceService(
            @RequestBody NearbyUserPublishPlaceEntity nearbyUserPublishPlaceEntity) {
        nearbyUserPublishPlaceService.addNearbyUserPublishPlace(nearbyUserPublishPlaceEntity);
        return ResponseEntity.ok("添加成功");
    }
}
