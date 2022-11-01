package com.example.yuye.dal.dao;

import com.example.yuye.dal.entity.Balance;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Balance)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-27 15:39:29
 */
public interface BalanceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Balance queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param balance  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Balance> queryAllByLimit(Balance balance, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param balance 查询条件
     * @return 总行数
     */
    long count(Balance balance);

    /**
     * 新增数据
     *
     * @param balance 实例对象
     * @return 影响行数
     */
    int insert(Balance balance);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Balance> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Balance> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Balance> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Balance> entities);

    /**
     * 修改数据
     *
     * @param balance 实例对象
     * @return 影响行数
     */
    int update(Balance balance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

