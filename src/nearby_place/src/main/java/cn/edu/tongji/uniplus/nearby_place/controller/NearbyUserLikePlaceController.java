package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.NearbyUserLikePlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyUserLikePlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户点赞地点")
@RestController
@RequestMapping("/api/v1/user-like-place")
public class NearbyUserLikePlaceController {
    @Autowired
    private NearbyUserLikePlaceService userLikePlaceService;

    /*
        查找指定userId喜欢的地方
     */
    @ApiOperation("查找指定ID的用户点赞的地点")
    @GetMapping("/id/{userId}")
    public ResponseEntity<List<NearbyUserLikePlaceEntity>> getNearbyPlaceByUserId(@PathVariable("userId") Long userId) {
        List<NearbyUserLikePlaceEntity> result = userLikePlaceService.getNearbyUserLikePlaceEntityByUserId(userId);
        if (result == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /*
        添加某个userId喜欢的地方
     */
    @ApiOperation("添加指定ID的用户点赞的地点")
    @PostMapping("")
    public ResponseEntity<String> addNearbyUserLikePlace(@RequestBody NearbyUserLikePlaceEntity nearbyUserLikePlaceEntity) {
        userLikePlaceService.addNearbyUserLikePlaceEntity(nearbyUserLikePlaceEntity);
        return ResponseEntity.status(HttpStatus.OK).body("添加成功");
    }

    /*
        删除某个userId喜欢的地方placeId
     */
    @ApiOperation("删除指定ID的用户点赞的指定ID的地方")
    @DeleteMapping("/id/{userId}")
    public ResponseEntity<String> deleteNearbyUserLikePlaceByUserId(@PathVariable("userId") Long userId, @RequestParam("placeId") Integer placeId) {
        userLikePlaceService.deleteNearbyUserLikePlaceEntity(userId, placeId);
        return ResponseEntity.status(HttpStatus.OK).body("删除成功");
    }

}
