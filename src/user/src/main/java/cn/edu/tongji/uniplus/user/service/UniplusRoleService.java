package cn.edu.tongji.uniplus.user.service;

import cn.edu.tongji.uniplus.user.repository.uniplusRoleRepository;
import cn.edu.tongji.uniplus.user.repository.uniplusUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UniplusRoleService {

    @Autowired
    private uniplusRoleRepository uniplusRoleRepository;
    @Autowired
    private uniplusUserRepository uniplusUserRepository;
    @Autowired
    private StpInterfaceImpl stpInterface;

    public void getPermissionList() {
        System.out.println(stpInterface.getPermissionList(10002L, "fuck"));
    }

}
