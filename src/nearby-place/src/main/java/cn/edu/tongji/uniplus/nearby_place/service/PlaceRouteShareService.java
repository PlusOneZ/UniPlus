package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceRouteShareEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceRouteShareRepository;
import cn.edu.tongji.uniplus.nearby_place.tool.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceRouteShareService {
    @Autowired
    private PlaceRouteShareRepository placeRouteShareRepository;

    /*
        添加 路线share
     */
    public PlaceRouteShareEntity add(PlaceRouteShareEntity placeRouteShareEntity) {
        return placeRouteShareRepository.save(placeRouteShareEntity);
    }

    /*
        通过分享者ID、模糊搜索查找路线share
        TODO: 服务层传参应该是越简单越好，试一下
     */
    public List<PlaceRouteShareEntity> findAllByUserId(Long UserId) {
        return placeRouteShareRepository.findPlaceRouteShareEntitiesByRoutePublisherId(UserId);
    }

    public List<PlaceRouteShareEntity> findAllByTitle(String partTitle) {
        return placeRouteShareRepository.findPlaceRouteShareEntitiesByShareRouteTitleContaining(partTitle);
    }

    /*
        修改评论内容，只修改对应的部分，其他的不能修改
        通过评论ID来找到比较好，因为毕竟是主码
     */
    public PlaceRouteShareEntity update(Integer shareId, PlaceRouteShareEntity after) {
        PlaceRouteShareEntity before = placeRouteShareRepository.findPlaceRouteShareEntityByRouteShareId(shareId);
        if (before == null)
            return null;
        if (after != null) {
            JpaUtil.copyNotNullProperties(after, before);
            return placeRouteShareRepository.save(before);
        }
        return null;
    }

    /*
        删除评论内容，也是通过评论ID来找
        TODO 目前的删除只是单独删除，多删我还没做
     */
    public void deleteByShareId(Integer shareId) {
        placeRouteShareRepository.deletePlaceRouteShareEntityByRouteShareId(shareId);
    }
}
