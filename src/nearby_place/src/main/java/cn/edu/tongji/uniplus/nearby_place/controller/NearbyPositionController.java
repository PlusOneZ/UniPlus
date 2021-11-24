package cn.edu.tongji.uniplus.nearby_place.controller;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPositionEntity;
import cn.edu.tongji.uniplus.nearby_place.service.NearbyPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nearby-position")

public class NearbyPositionController {
    @Autowired
    private NearbyPositionService nearbyPositionService;

    /*
        获取所有地点
     */
    @GetMapping("")
    public ResponseEntity<List<NearbyPositionEntity>> getAllNearbyPosition() {
        return ResponseEntity.status(HttpStatus.OK).body(nearbyPositionService.getAllNearbyPosition());
    }

    /*
        上传新的地点
     */
    @PostMapping("")
    public ResponseEntity<String> addNearbyPosition(@RequestBody NearbyPositionEntity nearbyPositionEntity) {
        nearbyPositionService.addNearbyPositionEntity(nearbyPositionEntity);
        return ResponseEntity.status(HttpStatus.OK).body("添加成功");
    }

    /*
        2种方式获取指定的地点
     */
    @GetMapping("/id/{positionId}")
    public ResponseEntity<NearbyPositionEntity> getNearbyPositionById(@PathVariable("positionId") Integer positionId) {
        NearbyPositionEntity result = nearbyPositionService.getNearbyPositionEntityById(positionId);
        if (result == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/name/{positionName}")
    public ResponseEntity<NearbyPositionEntity> getNearbyPositionByName(@PathVariable("positionName") String positionName) {
        NearbyPositionEntity result = nearbyPositionService.getNearbyPositionByName(positionName);
        if (result == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
