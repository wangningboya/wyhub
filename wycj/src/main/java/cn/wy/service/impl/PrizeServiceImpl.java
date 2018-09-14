package cn.wy.service.impl;

import cn.wy.entity.Account;
import cn.wy.entity.Page;
import cn.wy.entity.Prize;
import cn.wy.mapper.PrizeMapper;
import cn.wy.service.PrizeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PrizeServiceImpl implements PrizeService {

    @Resource
    private PrizeMapper prizeMapper;

    @Override
    public void add(Prize prize) {
        prizeMapper.add(prize);
    }

    @Override
    public void del(String prizeId) {
        prizeMapper.del(prizeId);
    }

    @Override
    public void edit(Prize prize) {
        prizeMapper.edit(prize);
    }

    @Override
    public List<Prize> getPrizeList(Page<Prize> page) {
        return prizeMapper.getPrizeList(page);
    }

    @Override
    public Prize getPrizeById(String prizeId) {
        return prizeMapper.getPrizeById(prizeId);
    }

    @Override
    public int count() {
        return prizeMapper.count();
    }
}
