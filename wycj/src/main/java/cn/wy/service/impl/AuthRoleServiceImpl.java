package cn.wy.service.impl;

import cn.wy.entity.Auth;
import cn.wy.mapper.AuthMapper;
import cn.wy.mapper.AuthRoleMapper;
import cn.wy.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthRoleServiceImpl implements AuthRoleService {

    @Resource
    private AuthRoleMapper authRoleMapper;

    @Resource
    private AuthMapper authMapper;

    @Override
    public List<String> findAuthIdByRoleId(String roleId) {
        return authRoleMapper.findAuthIdByRoleId(roleId);
    }

    @Override
    public Auth findAuthByAuthId(String authId) {
        return authMapper.findAuthByAuthId(authId);
    }
}
