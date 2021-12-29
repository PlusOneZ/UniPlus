package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.dto.NearbyPlaceDTO;
import cn.edu.tongji.uniplus.nearby_place.model.NearbyPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.model.PlaceImgEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.NearbyPlaceRepository;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceImgRepository;
import cn.edu.tongji.uniplus.nearby_place.tool.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NearbyPlaceService {
    //把 place 的信息和图片上传集成到一个服务类里了捏
    @Autowired
    private NearbyPlaceRepository nearbyPlaceRepository;
    @Autowired
    private PlaceImgRepository placeImgRepository;

    /*
        增加 NearbyPlace，建了个 DTO 用来传输两个类合起来的对象
        TODO: 这个需不需要在 Controller 层面上做一点对应的工作和改动？
        TODO: 暂时放成 void 类型了，看后面需不需要类似的内容，如果要的话再考虑怎么转化成 DTO
     */
    public void addNearbyPlace(NearbyPlaceEntity nearbyPlaceEntity) {
        nearbyPlaceRepository.save(nearbyPlaceEntity);
    }

    /*
        按 ID、名称 查找 NearbyPlace
     */
    public NearbyPlaceEntity getNearbyPlaceById(int Id) {
        return nearbyPlaceRepository.findNearbyPlaceEntityByPlaceId(Id);
    }

    public NearbyPlaceEntity getNearbyPlaceByName(String Name) {
        return nearbyPlaceRepository.findNearbyPlaceEntityByPlaceName(Name);
    }

    /*
        按 ID、名称 修改 NearbyPlace
     */
    public NearbyPlaceEntity updateNearbyPlaceById(int Id, NearbyPlaceEntity after) {
        NearbyPlaceEntity result = nearbyPlaceRepository.findNearbyPlaceEntityByPlaceId(Id);
        JpaUtil.copyNotNullProperties(after, result);
        nearbyPlaceRepository.save(result);
        return result;
    }

    /*
        获取当前placeId的所有照片
     */
    public List<PlaceImgEntity> findPlaceImgByPlaceId(Integer placeId) {
        return placeImgRepository.findPlaceImgEntitiesByPlaceId(placeId);
    }

    public List<NearbyPlaceEntity> findAllNearbyPlace() {
        return nearbyPlaceRepository.findAll();
    }

    /*
        删除指定placeId的指定ImgIndex的照片
     */
    @Transactional
    public void deletePlaceImgByPlaceIdAndPlaceImgIndex(Integer placeId, Integer placeImgIndex) {
        placeImgRepository.deletePlaceImgEntityByPlaceIdAndPlaceImgIndex(placeId, placeImgIndex);
    }

    /*
        按 ID、名称 删除 NearbyPlace
        TODO: 这个我先不做了，等到有需求的时候再做
     */
}
