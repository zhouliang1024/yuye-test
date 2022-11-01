package com.example.yuye.biz.service.impl;

import com.example.yuye.dal.entity.Balance;
import com.example.yuye.dal.dao.BalanceDao;
import com.example.yuye.biz.service.BalanceService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Balance)表服务实现类
 *
 * @author makejava
 * @since 2022-07-27 15:39:34
 */
@Service("balanceService")
public class BalanceServiceImpl implements BalanceService {
    @Resource
    private BalanceDao balanceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Balance queryById(Long id) {
        return this.balanceDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param balance     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Balance> queryByPage(Balance balance, PageRequest pageRequest) {
        long total = this.balanceDao.count(balance);
        return new PageImpl<>(this.balanceDao.queryAllByLimit(balance, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param balance 实例对象
     * @return 实例对象
     */
    @Override
    public Balance insert(Balance balance) {
        this.balanceDao.insert(balance);
        return balance;
    }

    /**
     * 修改数据
     *
     * @param balance 实例对象
     * @return 实例对象
     */
    @Override
    public Balance update(Balance balance) {
        this.balanceDao.update(balance);
        return this.queryById(balance.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.balanceDao.deleteById(id) > 0;
    }
}
