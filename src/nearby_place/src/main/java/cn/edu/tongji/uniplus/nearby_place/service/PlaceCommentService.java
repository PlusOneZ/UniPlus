package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceCommentEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceCommentService {
    @Autowired
    private PlaceCommentRepository placeCommentRepository;

    // 添加一条评论
    public void addComment(PlaceCommentEntity placeComment) {
        placeCommentRepository.save(placeComment);
    }
}
