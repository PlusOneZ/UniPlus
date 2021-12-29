package cn.edu.tongji.uniplus.nearby_place.service;

import cn.edu.tongji.uniplus.nearby_place.model.PlaceCommentEntity;
import cn.edu.tongji.uniplus.nearby_place.repository.PlaceCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceCommentService {
    @Autowired
    private PlaceCommentRepository placeCommentRepository;

    /*
        增加用户评论
     */
    public PlaceCommentEntity add(PlaceCommentEntity placeComment) {
        return placeCommentRepository.save(placeComment);
    }

    /*
        查找指定用户评论、指定 place 的评论、指定范围评分的评论
     */
    public List<PlaceCommentEntity> findAllByUserId(Long userId) {
        return placeCommentRepository.findPlaceCommentEntitiesByPlaceCommentUser(userId);
    }
    /*
        用户需要修改评论吗？需要删除评论吗？
        我觉得删是可以删，但是只能删自己的评论,实际上肯定是点哪条删哪条
        TODO 考虑过批量删除吗？
     */
    public void delete(Long commentId) {
        placeCommentRepository.deletePlaceCommentEntityByPlaceCommentId(commentId);
    }
    /*
        获取所有评论
     */
    public List<PlaceCommentEntity> getAll(){
        return placeCommentRepository.findAll();
    }
}
