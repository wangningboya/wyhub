package cn.wy.mapper;

import cn.wy.entity.Page;
import cn.wy.entity.Prize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrizeMapper {

    public void add(Prize prize);

    public void del(String prizeId);
    //列出奖品
    public List<Prize> getPrizeList(Page<Prize> page);

    //通过ID列出奖品
    public Prize getPrizeById(String prizeId);

    //修改奖品信息
    public void edit(Prize prize);

    //获取奖品种类数量
    public int count();
}
