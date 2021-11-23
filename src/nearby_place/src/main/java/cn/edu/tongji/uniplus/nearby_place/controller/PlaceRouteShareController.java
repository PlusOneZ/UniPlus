package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareTagEntity;
import cn.edu.tongji.uniplus.nearby_place.model.ShareRouteContainPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.service.PlaceRouteShareService;
import cn.edu.tongji.uniplus.nearby_place.service.PlaceRouteShareTagService;
import cn.edu.tongji.uniplus.nearby_place.service.ShareRouteContainPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/place_route_share")
public class PlaceRouteShareController {
    @Autowired
    private PlaceRouteShareService placeRouteShareService;
    @Autowired
    private PlaceRouteShareTagService placeRouteShareTagService;
    @Autowired
    private ShareRouteContainPlaceService shareRouteContainPlaceService;

    @PostMapping("/add/place_route_share")
    public ResponseEntity<String> addPlaceRouteShareService(
            @RequestBody PlaceRouteShareEntity placeRouteShareEntity) {
        placeRouteShareService.addPlaceRouteShare(placeRouteShareEntity);
        return ResponseEntity.ok("添加路线分享成功");
    }

    @PostMapping("/add/place_route_share_tag")
    public ResponseEntity<String> addPlaceRouteShareTag(@RequestBody PlaceRouteShareTagEntity placeRouteShareTagEntity) {
        placeRouteShareTagService.addPlaceRouteShareTag(placeRouteShareTagEntity);
        return ResponseEntity.ok("添加路线分享标签成功");
    }

    @PostMapping("/add/share_route_contain_place")
    public ResponseEntity<String> addShareRouteContainPlace(@RequestBody ShareRouteContainPlaceEntity shareRouteContainPlaceEntity) {
        shareRouteContainPlaceService.addShareRouteContainPlace(shareRouteContainPlaceEntity);
        return ResponseEntity.ok("添加路线分享内容地点成功");
    }
}
