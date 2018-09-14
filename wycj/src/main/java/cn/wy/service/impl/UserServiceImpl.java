package cn.wy.service.impl;

import cn.wy.entity.Account;
import cn.wy.entity.Page;
import cn.wy.mapper.AccountMapper;
import cn.wy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {
        accountMapper.add(account);
    }

    @Override
    public void del(String id) {

    }

    @Override
    public Account findByAccount(String userAccount) {
        Account account = accountMapper.findByAccount(userAccount);
        return  account;
    }

    @Override
    public int findByAccountAndPassword(Account account) {
        return accountMapper.findByAccountAndPassword(account);
    }

    @Override
    public List<String> findAccount() {
        return accountMapper.findAccount();
    }

    @Override
    public List<Account> findAllUser(Page<Account> page) {
        return accountMapper.findAllUser(page);
    }

    @Override
    public int count() {
        return accountMapper.count();
    }
}
