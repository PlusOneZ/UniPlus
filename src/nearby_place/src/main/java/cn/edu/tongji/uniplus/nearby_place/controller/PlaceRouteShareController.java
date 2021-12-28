package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.service.PlaceRouteShareService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户出行路线分享，制作中")
@RestController
@RequestMapping("/api/v1/route")
public class PlaceRouteShareController {
    @Autowired
    private PlaceRouteShareService placeRouteShareService;

}
