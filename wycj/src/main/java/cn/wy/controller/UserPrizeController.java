package cn.wy.controller;

import cn.wy.dto.UserPrizeDto;
import cn.wy.entity.Account;
import cn.wy.entity.Page;
import cn.wy.entity.UserPrize;
import cn.wy.service.UserPrizeService;
import cn.wy.service.UserService;
import cn.wy.util.RandomId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserPrizeController {

    @Resource
    private UserService userService;

    @Resource
    private UserPrizeService userPrizeService;

    //其他系统测试用
    @RequestMapping(value = "/test")
    public void test2()throws Exception{
        System.out.println("**********************");
    }

    //到抽奖记录界面
    @RequestMapping(value = "toRecord")
    public ModelAndView toRecord(
            HttpServletRequest request
    )throws Exception{
        ModelAndView modelAndView=new ModelAndView("record");
        HttpSession session=request.getSession();
        String userAccount=session.getAttribute("userAccount").toString();
        Account account=userService.findByAccount(userAccount);
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    //到所有抽奖记录界面
    @RequestMapping(value = "/toAllRecord")
    public ModelAndView toAllRecord(
            HttpServletRequest request
    )throws Exception{
        ModelAndView modelAndView=new ModelAndView("allRecord");
        HttpSession session=request.getSession();
        String userAccount=session.getAttribute("userAccount").toString();
        Account account=userService.findByAccount(userAccount);
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    //到用户管理界面
    @RequestMapping(value = "/toUserManage")
    public ModelAndView toUserManage(
            HttpServletRequest request
    )throws Exception{
        ModelAndView modelAndView=new ModelAndView("userManage");
        HttpSession session=request.getSession();
        String userAccount=session.getAttribute("userAccount").toString();
        Account account=userService.findByAccount(userAccount);
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    //跳转到哥哥用户管理界面
    @RequestMapping(method= RequestMethod.GET ,value = "/toUserManages")
    public ModelAndView toUserManages(
            HttpServletRequest request
    )throws Exception{
        ModelAndView modelAndView=new ModelAndView("userManages");
        HttpSession session=request.getSession();
        String userAccount=session.getAttribute("userAccount").toString();
        Account account=userService.findByAccount(userAccount);
        request.setCharacterEncoding("utf-8");
        String userId=request.getParameter("userId");
        modelAndView.addObject("userId",userId);
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    @RequestMapping(method= RequestMethod.POST ,value = "/addUserPrize")
    @ResponseBody
    public int addUserPrize(
            UserPrize userPrize
    )throws Exception{
        userPrize.setId(RandomId.getUUID32());
        userPrize.setPrizeTime(new Date());
        userPrize.setIsDelete("0");
        userPrize.setState("0");
        userPrizeService.add(userPrize);
        return 1;
    }

    @RequestMapping(method= RequestMethod.POST ,value = "/delUserPrizeById")
    @ResponseBody
    public int delUserPrizeById(
            String id
    )throws Exception{
        userPrizeService.del(id);
        return 1;
    }

    //获取所有获奖信息
    @RequestMapping(method= RequestMethod.POST ,value = "/findUserPrizeDtoList")
    @ResponseBody
    public Object findUserPrizeDtoList(
            @RequestParam(value="limit",defaultValue="10")String limit,
            @RequestParam(value="offset",defaultValue="0")String offset
    )throws Exception{
        System.out.println("获取所有获奖信息");

        Page<UserPrizeDto> page=new Page<UserPrizeDto>();
        page.setLimit(Integer.parseInt(limit));
        page.setOffset(Integer.parseInt(offset));

        List<UserPrizeDto> userPrizesList=new ArrayList<>();
        userPrizesList=userPrizeService.findUserPrizeDtoList(page);
        page.setRows(userPrizesList);
        page.setTotal(userPrizeService.count(page));

        Map<String, Object> result=new HashMap<String, Object>();
        result.put("total",page.getTotal());
        result.put("rows",page.getRows());
        return result;
    }

    //根据userid获取所有获奖信息
    @RequestMapping(method= RequestMethod.POST ,value = "/findUserPrizeDtoListByUserId")
    @ResponseBody
    public Object findUserPrizeDtoListByUserId(
            @RequestParam(value="limit",defaultValue="10")String limit,
            @RequestParam(value="offset",defaultValue="0")String offset,
            @RequestParam(value="userId",defaultValue="0")String userId
    )throws Exception{
        System.out.println("根据userid获取所有获奖信息");

        Page<UserPrizeDto> page=new Page<UserPrizeDto>();
        page.setLimit(Integer.parseInt(limit));
        page.setOffset(Integer.parseInt(offset));

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("userId",userId);
        page.setParams(map);

        List<UserPrizeDto> userPrizesList=new ArrayList<>();
        userPrizesList=userPrizeService.findUserPrizeDtoListByUserId(page);
        page.setRows(userPrizesList);
        System.out.println("ssssss"+userPrizeService.count(page));
        page.setTotal(userPrizeService.count(page));

        Map<String, Object> result=new HashMap<String, Object>();
        result.put("total",page.getTotal());
        result.put("rows",page.getRows());
        return result;
    }

    //根据id领奖
    @RequestMapping(method= RequestMethod.POST ,value = "/awardById")
    @ResponseBody
    public int awardById(
            String id
    )throws Exception{
        System.out.println("根据id领奖");
        userPrizeService.awardById(id);
        return 1;
    }




//    @RequestMapping(method= RequestMethod.POST ,value = "/findUserPrizeJson")
//    @ResponseBody
//    public JSONArray findListJson()throws Exception{
//        List<UserPrizeDto> userPrizesList=new ArrayList<>();
//        userPrizesList=userPrizeService.findUserPrizeDtoList();
//        JSONArray jsonArray=new JSONArray();
//        for(int i=0;i<userPrizesList.size();i++){
//            JSONObject jsonObject=new JSONObject();
//            jsonObject.put("userId",userPrizesList.get(i).getUserId());
//            jsonObject.put("prizeId",userPrizesList.get(i).getPrizeId());
//            jsonObject.put("prizeTime",userPrizesList.get(i).getPrizeTime());
//            jsonArray.put(jsonObject);
//        }
//        System.out.println(jsonArray.toString());
//        return jsonArray;
//    }
//    private Date changeDate(Date date){
//        String text = date.toString();
//        DateFormat formate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        DateFormat formate2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
//        Date date = formate2.parse(text);
//        String dateString = formate1.format(date);
//    }
}
