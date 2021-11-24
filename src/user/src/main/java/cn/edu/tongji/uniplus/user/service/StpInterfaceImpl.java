package cn.edu.tongji.uniplus.user.service;

import cn.dev33.satoken.stp.StpInterface;
import cn.edu.tongji.uniplus.user.model.RoleEntity;
import cn.edu.tongji.uniplus.user.model.UserEntity;
import cn.edu.tongji.uniplus.user.repository.RoleRepository;
import cn.edu.tongji.uniplus.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    private UserRepository uniplusUserRepository;
    @Autowired
    private RoleRepository uniplusRoleRepository;

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> list = new ArrayList<>();
        Long l = Long.valueOf(String.valueOf(loginId));
        UserEntity targetUser = uniplusUserRepository.findByUserId(l);
        Optional<RoleEntity> targetRole = uniplusRoleRepository.findById(targetUser.getUserRole());
        //这是从sa-token给的接口里搞得，只能加入字符串类型的名字而不是id...无语
        list.add(targetRole.map(RoleEntity::getRoleName).orElse(null));
        return list;
    }

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<String>();
        Long l = Long.valueOf(String.valueOf(loginId));
        UserEntity targetUser = uniplusUserRepository.findByUserId(l);
        Optional<RoleEntity> targetRoleOptional = uniplusRoleRepository.findById(targetUser.getUserRole());
        //这是sa-token扩展出的函数，没法改变类型，很烦，然后我就自己把权限当作字符串给处理了。
        //这对应四种类型的权限
        if (targetRoleOptional.isEmpty()) return list;
        RoleEntity targetRole = targetRoleOptional.get();
        if (targetRole.isRoleCanComment())
            list.add("comment");
        if (targetRole.isRoleCanPost())
            list.add("post");
        if (targetRole.isRoleCanPublishGood())
            list.add("publish");
        if (targetRole.isRoleCanTrade())
            list.add("trade");
        return list;
    }
}
