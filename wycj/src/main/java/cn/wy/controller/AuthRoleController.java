package cn.wy.controller;

import cn.wy.entity.Account;
import cn.wy.entity.Auth;
import cn.wy.service.AuthRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthRoleController {

    @Resource
    private AuthRoleService authRoleService;

    //获取权限
    @RequestMapping(value = "findAuthByRoleId")
    @ResponseBody
    public List<Auth> getAuth(
            @RequestParam(value="roleId",defaultValue="")String roleId
    )throws Exception {
        List<Auth> authList=new ArrayList<>();
        List<String> list=authRoleService.findAuthIdByRoleId(roleId);
        for (int i=0;i<list.size();i++){
            authList.add(authRoleService.findAuthByAuthId(list.get(i)));
        }
        return authList;
    }
}
