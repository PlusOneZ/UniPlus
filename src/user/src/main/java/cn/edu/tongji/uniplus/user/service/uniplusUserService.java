package cn.edu.tongji.uniplus.user.service;

import cn.edu.tongji.uniplus.user.model.uniplusUser;
import cn.edu.tongji.uniplus.user.repository.uniplusUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class uniplusUserService {
    @Autowired
    private uniplusUserRepository uniplusUserRepository;

    public String userRegister(uniplusUser newUser) {
        return uniplusUserRepository.save(newUser).getUserId().toString();
    }

    public Integer userLogin(uniplusUser loginUser) {
        if (uniplusUserRepository.findByUserId(loginUser.getUserId()) == null) // 没这个账号
            return -1;
            //账号有，但是和密码对不上
        else if (uniplusUserRepository.findByUserIdAndUserPassword(loginUser.getUserId(), loginUser.getUserPassword()) == null)
            return 404;
            // 都对上了
        else
            return 200;
    }
}
