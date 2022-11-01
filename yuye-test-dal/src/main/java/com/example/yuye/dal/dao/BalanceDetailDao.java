package com.example.yuye.dal.dao;

import com.example.yuye.dal.entity.BalanceDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 账单(BalanceDetail)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-26 17:56:18
 */
public interface BalanceDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BalanceDetail queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param balanceDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BalanceDetail> queryAllByLimit(BalanceDetail balanceDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param balanceDetail 查询条件
     * @return 总行数
     */
    long count(BalanceDetail balanceDetail);

    /**
     * 新增数据
     *
     * @param balanceDetail 实例对象
     * @return 影响行数
     */
    int insert(BalanceDetail balanceDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BalanceDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BalanceDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BalanceDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BalanceDetail> entities);

    /**
     * 修改数据
     *
     * @param balanceDetail 实例对象
     * @return 影响行数
     */
    int update(BalanceDetail balanceDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

