package cn.wy.service;

import cn.wy.entity.Account;
import cn.wy.entity.Page;

import java.util.List;

/**
 * 用户管理
 */
public interface UserService {

    //添加用户
    public void save(Account account);

    //删除用户
    public void del(String id);

    //根据账号查询用户
    public Account findByAccount(String userAccount);

    //登录检查
    public int findByAccountAndPassword(Account userAccount);

    //查找所有账号
    public List<String> findAccount();

    //查找所有用户信息
    public List<Account> findAllUser(Page<Account> page);

    //获取用户数量
    public int count();
}
