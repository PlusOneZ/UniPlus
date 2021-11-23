package cn.edu.tongji.uniplus.nearby_place.dto;

import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class NearbyPlaceDTO {

    @Getter
    @Setter
    private NearbyPlaceEntity nearbyPlaceEntity;

    @Getter
    @Setter
    private PlaceImgEntity placeImgEntity;

    public NearbyPlaceDTO() {

    }

    public NearbyPlaceDTO(NearbyPlaceEntity nearbyPlaceEntity, PlaceImgEntity placeImgEntity) {
        this.nearbyPlaceEntity = nearbyPlaceEntity;
        this.placeImgEntity = placeImgEntity;
    }
}
