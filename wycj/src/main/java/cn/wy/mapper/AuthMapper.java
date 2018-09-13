package cn.wy.mapper;

import cn.wy.entity.Auth;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthMapper {
    //根据权限id查找权限信息
    public Auth findAuthByAuthId(String authId);
}
