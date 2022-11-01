package com.example.yuye.biz.service;

import com.example.yuye.biz.request.CreateOrderRequest;
import com.example.yuye.dal.entity.PayOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (PayOrder)表服务接口
 *
 * @author makejava
 * @since 2022-07-26 17:56:39
 */
public interface PayOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PayOrder queryById(Long id);

    PayOrder queryByPayNo(String payNo);

    /**
     * 分页查询
     *
     * @param payOrder    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<PayOrder> queryByPage(PayOrder payOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param payOrder 实例对象
     * @return 实例对象
     */
    PayOrder insert(PayOrder payOrder);

    /**
     * 修改数据
     *
     * @param payOrder 实例对象
     * @return 实例对象
     */
    PayOrder update(PayOrder payOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 创单
     * @param createOrderRequest
     * @return
     */
    String createOrder(CreateOrderRequest createOrderRequest);
}
