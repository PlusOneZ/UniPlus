package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceCommentEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.placeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class placeCommentService {
    @Autowired
    private placeCommentRepository placeCommentRepository;

    // 添加一条评论
    public void addComment(PlaceCommentEntity placeComment) {
        placeCommentRepository.save(placeComment);
    }
}
