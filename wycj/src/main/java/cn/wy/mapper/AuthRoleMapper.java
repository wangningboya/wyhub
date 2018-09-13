package cn.wy.mapper;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AuthRoleMapper {
    //根据角色Id获取权限Id
    public List<String> findAuthIdByRoleId(String roleId);
}
