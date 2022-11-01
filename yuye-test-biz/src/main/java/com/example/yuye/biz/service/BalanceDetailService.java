package com.example.yuye.biz.service;

import com.example.yuye.dal.entity.BalanceDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 账单(BalanceDetail)表服务接口
 *
 * @author makejava
 * @since 2022-07-26 17:56:20
 */
public interface BalanceDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BalanceDetail queryById(Long id);

    /**
     * 分页查询
     *
     * @param balanceDetail 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BalanceDetail> queryByPage(BalanceDetail balanceDetail, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param balanceDetail 实例对象
     * @return 实例对象
     */
    BalanceDetail insert(BalanceDetail balanceDetail);

    /**
     * 修改数据
     *
     * @param balanceDetail 实例对象
     * @return 实例对象
     */
    BalanceDetail update(BalanceDetail balanceDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
