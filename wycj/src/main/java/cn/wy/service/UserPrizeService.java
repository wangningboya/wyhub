package cn.wy.service;

import cn.wy.dto.UserPrizeDto;
import cn.wy.entity.Page;
import cn.wy.entity.UserPrize;

import java.util.List;

public interface UserPrizeService {

    public void add(UserPrize userPrize);

    public void del(String id);

    //获取用户得奖列表
    public List<UserPrizeDto> findUserPrizeDtoList(Page<UserPrizeDto> page);

    //根据userid获取用户得奖列表
    public List<UserPrizeDto> findUserPrizeDtoListByUserId(Page<UserPrizeDto> page);

    //根据id领奖
    public void awardById(String id);

    //获取记录条数
    public int count(Page<UserPrizeDto> page);
}
