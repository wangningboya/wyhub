package cn.wy.mapper;

import cn.wy.dto.UserPrizeDto;
import cn.wy.entity.Page;
import cn.wy.entity.UserPrize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPrizeMapper {

    public void add(UserPrize userPrize);

    public void del(String id);

    //查询获奖信息
    public List<UserPrizeDto> findUserPrizeDtoList(Page<UserPrizeDto> page);

    //根据userid查询获奖信息
    List<UserPrizeDto> findUserPrizeDtoListByUserId(Page<UserPrizeDto> page);

    //根据id领奖
    public void awardById(String id);

    //获取记录条数
    public int count(Page<UserPrizeDto> page);
}
