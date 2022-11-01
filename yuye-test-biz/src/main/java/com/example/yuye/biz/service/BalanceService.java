package com.example.yuye.biz.service;

import com.example.yuye.dal.entity.Balance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Balance)表服务接口
 *
 * @author makejava
 * @since 2022-07-27 15:39:32
 */
public interface BalanceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Balance queryById(Long id);

    /**
     * 分页查询
     *
     * @param balance     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Balance> queryByPage(Balance balance, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param balance 实例对象
     * @return 实例对象
     */
    Balance insert(Balance balance);

    /**
     * 修改数据
     *
     * @param balance 实例对象
     * @return 实例对象
     */
    Balance update(Balance balance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
