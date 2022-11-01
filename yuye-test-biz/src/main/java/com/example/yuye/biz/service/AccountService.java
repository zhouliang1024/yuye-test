package com.example.yuye.biz.service;

import com.example.yuye.dal.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 账户(Account)表服务接口
 *
 * @author makejava
 * @since 2022-07-26 19:19:58
 */
public interface AccountService {

    /**
     * 通过用户id和账号类型查询账户，如果不存在则初始化账户（不做额外的开户过程）
     *
     * @param userId
     * @param type
     * @return
     */
    Account queryAccount(String userId, Integer type);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Account queryById(Long id);

    /**
     * 分页查询
     *
     * @param account 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Account> queryByPage(Account account, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account insert(Account account);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account update(Account account);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
