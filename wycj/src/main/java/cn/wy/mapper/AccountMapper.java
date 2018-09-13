package cn.wy.mapper;

import cn.wy.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    //新增
    public void add(Account pojo);
    //修改
    public void edit(Account pojo);
    //删除
    public void del(String id);


    //查询所有用户
    //List<AccountDto> selectAllAccount(Map<String, Object> params);

    //根据账号查询Account用户
    public Account findByAccount(String account);

    //public List<ManageMenuAndAuthDto> selectManageMenuAndAuthList(Map<String, Object> params);

    Long ckAccount(String account);

    //  根据用户名查询权限菜单
//    public List<UserMenusDto> queryMenusByUserName(String name);

    //登录检查
    public int findByAccountAndPassword(Account account);

    //查找所有账号
    public List<String> findAccount();

    //查找所有用户信息
    public List<Account> findAllUser();
}
