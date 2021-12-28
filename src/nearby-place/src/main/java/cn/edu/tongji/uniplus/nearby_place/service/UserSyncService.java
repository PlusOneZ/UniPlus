package cn.edu.tongji.uniplus.nearby_place.service;

import org.springframework.stereotype.Service;

@Service
public interface UserSyncService {

    void addUser(Long userId, String nickName);

    void deleteUser(Long userId);

}
