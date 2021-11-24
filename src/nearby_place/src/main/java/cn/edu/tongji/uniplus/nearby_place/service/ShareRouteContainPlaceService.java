package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.ShareRouteContainPlaceEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.ShareRouteContainPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareRouteContainPlaceService {
    @Autowired
    private ShareRouteContainPlaceRepository shareRouteContainPlaceRepository;

}
