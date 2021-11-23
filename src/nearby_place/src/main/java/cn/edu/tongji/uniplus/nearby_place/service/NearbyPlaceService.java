package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.dto.NearbyPlaceDTO;
import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.NearbyPlaceRepository;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NearbyPlaceService {
    //把place的信息和图片上传集成到一个服务类里了捏
    @Autowired
    private NearbyPlaceRepository nearbyPlaceRepository;
    @Autowired
    private PlaceImgRepository placeImgRepository;

    /*
        增加 NearbyPlace，建了个 DTO 用来传输两个类合起来的对象
        // TODO: 这个需不需要在 Controller 层面上做一点对应的工作和改动？
        // TODO: 暂时放成 void 类型了，看后面需不需要类似的内容，如果要的话再考虑怎么转化成 DTO
     */
    public void addNearbyPlaceDTO(NearbyPlaceDTO nearbyPlaceDTO) {
        nearbyPlaceRepository.save(nearbyPlaceDTO.getNearbyPlaceEntity());
        placeImgRepository.save(nearbyPlaceDTO.getPlaceImgEntity());
    }

    /*
        按 ID、名称 查找 NearbyPlace
     */
    public NearbyPlaceDTO getNearbyPlaceById(int Id) {
        NearbyPlaceDTO result = new NearbyPlaceDTO();
        result.setNearbyPlaceEntity(nearbyPlaceRepository.findNearbyPlaceEntityByPlaceId(Id));
        result.setPlaceImgEntity(placeImgRepository.findPlaceImgEntityByPlaceId(Id));
        return result;
    }

    public NearbyPlaceDTO getNearbyPlaceByName(String Name) {
        NearbyPlaceDTO result = new NearbyPlaceDTO();
        result.setNearbyPlaceEntity(nearbyPlaceRepository.findNearbyPlaceEntityByPlaceName(Name));
        result.setPlaceImgEntity(placeImgRepository.findPlaceImgEntityByPlaceId(nearbyPlaceRepository.findNearbyPlaceEntityByPlaceName(Name).getPlaceId()));
        return result;
    }

    /*
        按 ID、名称 修改 NearbyPlace
     */

    /*
        按 ID、名称 修改 NearbyPlace
     */
}
