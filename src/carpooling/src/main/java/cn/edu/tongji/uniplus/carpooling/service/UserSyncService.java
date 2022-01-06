package cn.edu.tongji.uniplus.carpooling.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface UserSyncService {

    void addUser(Long userId, String nickName) throws IOException;

    void deleteUser(Long userId);

}
