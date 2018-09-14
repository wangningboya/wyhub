package cn.wy.controller;

import cn.wy.entity.Account;
import cn.wy.entity.Page;
import cn.wy.entity.Prize;
import cn.wy.service.PrizeService;
import cn.wy.service.UserService;
import cn.wy.util.RandomId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PrizeController {

    @Resource
    private UserService userService;

    @Resource
    PrizeService prizeService;

    @RequestMapping(value = "toPrize")
    public ModelAndView toPrize(
            HttpServletRequest request
    ){
        ModelAndView modelAndView=new ModelAndView("prize");
        HttpSession session=request.getSession();
        String userAccount=session.getAttribute("userAccount").toString();
        Account account=userService.findByAccount(userAccount);
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    //获取奖品信息
    @RequestMapping(value = "/getPrizeList" , method = RequestMethod.POST)
    @ResponseBody
    public Object getPrizeList(
            @RequestParam(value = "limit",defaultValue = "10")String limit,
            @RequestParam(value = "offset",defaultValue = "0")String offset,
            @RequestParam(value = "type",defaultValue = "")String type
    ) throws Exception{
        System.out.println("获取奖品信息");

        Page<Prize> page=new Page<Prize>();
        page.setLimit(Integer.parseInt(limit));
        page.setOffset(Integer.parseInt(offset));

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("type",type);
        page.setParams(map);

        page.setRows(prizeService.getPrizeList(page));
        page.setTotal(prizeService.count());

        Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows",page.getRows());
        result.put("total",page.getTotal());
        return result;
    }

    //通过ID获取奖品信息
    @RequestMapping(value = "/getPrizeById" , method = RequestMethod.POST)
    @ResponseBody
    public Prize getPrizeById(
            String prizeId
    )throws Exception{
        System.out.println("通过ID获取奖品信息");
        Prize prize=new Prize();
        prize=prizeService.getPrizeById(prizeId);
        return prize;
    }

    //通过ID修改奖品信息
    @RequestMapping(value = "/editPrize" , method = RequestMethod.POST)
    @ResponseBody
    public int editPrize(
            Prize prize
    )throws Exception{
        System.out.println("通过ID修改奖品信息");
        prize.setIsDelete("0");
        prizeService.edit(prize);
        return 1;
    }

    //添加奖品
    @RequestMapping(value = "addPrize")
    @ResponseBody
    public int addPrize(
            Prize prize
    )throws Exception{
        System.out.println("添加奖品");
        prize.setPrizeId(RandomId.getUUID32());
        prize.setIsDelete("0");
        prizeService.add(prize);
        return 1;
    }

    //删除奖品
    @RequestMapping(value = "delPrizeById")
    @ResponseBody
    public int delPrizeById(
        String prizeId
    )throws Exception{
        prizeService.del(prizeId);
        return 1;
    }
}
