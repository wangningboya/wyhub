package cn.wy.service;

import cn.wy.entity.Account;
import cn.wy.entity.Page;
import cn.wy.entity.Prize;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Prize> getPrizeList(Page<Prize> page);

    //根据id获取奖品
    public Prize getPrizeById(String prizeId);

    //获取奖品种类数量
    public int count();
}
