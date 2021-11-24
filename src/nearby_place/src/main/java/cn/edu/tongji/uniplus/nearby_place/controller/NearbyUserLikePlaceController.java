package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserLikePlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyUserLikePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user_like_place")
public class NearbyUserLikePlaceController {
    @Autowired
    private NearbyUserLikePlaceService userLikePlaceService;
}
