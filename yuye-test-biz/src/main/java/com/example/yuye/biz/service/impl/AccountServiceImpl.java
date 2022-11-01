package com.example.yuye.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.yuye.biz.dto.TransferContext;
import com.example.yuye.biz.service.AccountService;
import com.example.yuye.dal.entity.Account;
import com.example.yuye.dal.dao.AccountDao;
import com.example.yuye.domain.transfer.Transfer;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * 账户(Account)表服务实现类
 *
 * @author makejava
 * @since 2022-07-26 19:19:59
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public Account queryAccount(String userId, Integer type) {
        ArrayList<String> strings = new ArrayList<>();
        Account account = accountDao.queryByUserIdAndType(userId, type);
        if (Objects.isNull(account)){
            Account addAccount = new Account();
            addAccount.setUserId(userId);
            addAccount.setType(type);
            addAccount.setGmtCreated(new Date());
            addAccount.setGmtModified(new Date());
            addAccount.setAmount(0L);
            accountDao.insert(addAccount);
            return addAccount;
        }
        return account;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Account queryById(Long id) {
        return this.accountDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param account 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Account> queryByPage(Account account, PageRequest pageRequest) {
        long total = this.accountDao.count(account);
        return new PageImpl<>(this.accountDao.queryAllByLimit(account, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account insert(Account account) {
        this.accountDao.insert(account);
        return account;
    }

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account update(Account account) {
        this.accountDao.update(account);
        return this.queryById(account.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.accountDao.deleteById(id) > 0;
    }
}
