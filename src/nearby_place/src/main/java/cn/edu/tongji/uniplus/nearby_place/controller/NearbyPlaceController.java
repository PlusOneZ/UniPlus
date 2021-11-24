package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/nearby_place")

public class NearbyPlaceController {
    @Autowired
    private NearbyPlaceService nearbyPlaceService;
}
