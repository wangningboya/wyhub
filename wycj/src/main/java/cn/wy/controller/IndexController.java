package cn.wy.controller;


import cn.wy.entity.Account;
import cn.wy.entity.Auth;
import cn.wy.service.AuthRoleService;
import cn.wy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserService userService;



    /**
     * 跳转登录界面
     */
    @RequestMapping(method= RequestMethod.GET,value = "/index")
    public ModelAndView index(
            HttpServletRequest request
    )throws Exception{
        ModelAndView indexModel=new ModelAndView("index");
        ModelAndView loginModel=new ModelAndView("login");
        HttpSession session=request.getSession();
        if(session.getAttribute("userAccount")==""||session.getAttribute("userAccount")==null){
            return loginModel;
        }else{
            String userAccount=session.getAttribute("userAccount").toString();
            Account account=userService.findByAccount(userAccount);
            indexModel.addObject("account",account);
            return indexModel;
        }
    }


}
