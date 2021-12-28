package cn.edu.tongji.uniplus.nearby_place.dto;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
    这个类是为了组合 place 和 placeImg 的一个 DTO层
    到时候返回数据的时候会返回这个东西
 */
public class NearbyPlaceDTO {

    @Getter
    @Setter
    private NearbyPlaceEntity nearbyPlaceEntity;

    @Getter
    @Setter
    private List<PlaceImgEntity> placeImgEntity;

    public NearbyPlaceDTO() {

    }

    public NearbyPlaceDTO(NearbyPlaceEntity nearbyPlaceEntity, List<PlaceImgEntity> placeImgEntity) {
        this.nearbyPlaceEntity = nearbyPlaceEntity;
        this.placeImgEntity = placeImgEntity;
    }
}
