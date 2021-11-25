package cn.edu.tongji.uniplus.user.service;

import cn.edu.tongji.uniplus.user.repository.RoleRepository;
import cn.edu.tongji.uniplus.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StpInterfaceImpl stpInterface;

    public void getPermissionList() {
        System.out.println(stpInterface.getPermissionList(10002L, "fuck"));
    }

}
