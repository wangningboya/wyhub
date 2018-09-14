package cn.wy.service.impl;

import cn.wy.dto.UserPrizeDto;
import cn.wy.entity.Page;
import cn.wy.entity.UserPrize;
import cn.wy.mapper.UserPrizeMapper;
import cn.wy.service.UserPrizeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserPrizeServiceImpl implements UserPrizeService {

    @Resource
    private UserPrizeMapper userPrizeMapper;

    @Override
    public void add(UserPrize userPrize) {
        userPrizeMapper.add(userPrize);
    }

    @Override
    public void del(String id) {
        userPrizeMapper.del(id);
    }

    @Override
    public List<UserPrizeDto> findUserPrizeDtoList(Page<UserPrizeDto> page) {
        return userPrizeMapper.findUserPrizeDtoList(page);
    }

    @Override
    public List<UserPrizeDto> findUserPrizeDtoListByUserId(Page<UserPrizeDto> page) {
        return userPrizeMapper.findUserPrizeDtoListByUserId(page);
    }

    @Override
    public void awardById(String id) {
        userPrizeMapper.awardById(id);
    }

    @Override
    public int count(Page<UserPrizeDto> page) {
        return userPrizeMapper.count(page);
    }
}
