package cn.wy.service;

import cn.wy.entity.Account;
import cn.wy.entity.Prize;

import java.util.List;

/**
 * 奖品
 */
public interface PrizeService {

    //添加奖品
    public void add(Prize prize);

    //删除奖品
    public void del(String prizeId);

    //修改奖品
    public void edit(Prize prize);

    //列出奖品
    public List<Prize> getPrizeList();

    public Prize getPrizeById(String prizeId);

}
