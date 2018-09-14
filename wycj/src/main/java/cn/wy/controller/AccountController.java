package cn.wy.controller;

import cn.wy.entity.Account;
import cn.wy.entity.Page;
import cn.wy.service.UserService;
import cn.wy.util.RandomId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountController {

    @Resource
    private UserService userService;

    /**
     * 跳转到登录界面
     */
    @RequestMapping(value = "/login" , method=RequestMethod.GET)
    public String Login(){
        System.out.println("跳转登录界面");
        return "login";
    }

    /**
     * 跳转到注册界面
     */
    @RequestMapping(value = "/register" , method=RequestMethod.GET)
    public String Register(){
        System.out.println("跳转注册界面");
        return "register";
    }

    /**
     * 跳转到登出界面
     */
    @RequestMapping(value = "/logout")
    public String Logout(HttpServletRequest request){
        request.getSession().invalidate();
        System.out.println("登出成功");
        return "login";
    }

    /**
     * 账号检测
     */
    @RequestMapping(value = "/checkAccount")
    @ResponseBody
    public List<String> checkAccount(HttpServletRequest request){
        List<String> accountList=new ArrayList<>();
        accountList=userService.findAccount();
        return accountList;
    }

    /**
     * 登录检测
     */
    @RequestMapping(method= RequestMethod.POST,value = "/login2")
    @ResponseBody
    public Account Login2(
            Account account,
            HttpServletRequest request
    )throws Exception{
        System.out.println("登录检测");
        String userAccount=account.getUserAccount();
        String userPwd=account.getUserPwd();
        System.out.println("userAccount="+userAccount+"userPwd="+userPwd);
        Account ac=userService.findByAccount(userAccount);
        if(ac!=null){
            Account ac2=new Account();
            ac2.setUserAccount(userAccount);
            ac2.setUserPwd(userPwd);
            int a=userService.findByAccountAndPassword(ac2);
            if(a==1){
                //登录成功
                System.out.println("登录成功");
                HttpSession session =request.getSession();
                session.setAttribute("userAccount",userAccount);
                session.setAttribute("userPwd",userPwd);
                return ac2;
            }else {
                //账号或者密码错误
                ac2.setUserPwd("");
                System.out.println("账号或者密码错误");
                return ac2;
            }
        }else {
            //账号不存在
            System.out.println("账号不存在");
            return ac;
        }
    }

    /**
     * 注册
     */
    @RequestMapping(method= RequestMethod.POST,value = "/register2")
    @ResponseBody
    public int register2(
            Account account,
            HttpServletRequest request
    )throws Exception{
        System.out.println("开始注册");
        account.setUserId(RandomId.getUUID32());
        account.setRoleId("1");
        account.setIsDelete("0");
        System.out.println(account.toString());
        userService.save(account);
        HttpSession session =request.getSession();
        session.setAttribute("userAccount",account.getUserAccount());
        session.setAttribute("userPwd",account.getUserPwd());
        return 1;
    }

    /**
     * 获取所有账户信息
     */
    @RequestMapping(value = "/findAllUser")
    @ResponseBody
    public Object findAllUser(
            @RequestParam(value="limit",defaultValue="10")String limit,
            @RequestParam(value="offset",defaultValue="0")String offset
    ) throws Exception{
        System.out.println("获取所有账户信息");

        Page<Account> page=new Page<Account>();
        page.setLimit(Integer.parseInt(limit));
        page.setOffset(Integer.parseInt(offset));

        List<Account> accountList=new ArrayList<>();
        accountList=userService.findAllUser(page);

        page.setRows(accountList);
        page.setTotal(userService.count());

        Map<String,Object> result=new HashMap<String, Object>();
        result.put("rows",page.getRows());
        result.put("total",page.getTotal());
        return result;
    }
}
