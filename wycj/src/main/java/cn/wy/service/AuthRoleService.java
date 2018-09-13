package cn.wy.service;

import cn.wy.entity.Auth;

import java.util.List;

public interface AuthRoleService {

    //根据角色Id查找权限Id
    public List<String> findAuthIdByRoleId(String roleId);

    //根据权限ID查找权限
    public Auth findAuthByAuthId(String authId);
}
