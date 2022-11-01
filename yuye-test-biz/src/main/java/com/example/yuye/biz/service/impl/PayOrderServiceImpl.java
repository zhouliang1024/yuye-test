package com.example.yuye.biz.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.example.yuye.biz.mapping.PayOrderMapping;
import com.example.yuye.biz.request.CreateOrderRequest;
import com.example.yuye.biz.service.PayOrderService;
import com.example.yuye.dal.dao.PayOrderDao;
import com.example.yuye.dal.entity.PayOrder;
import com.example.yuye.domain.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (PayOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-07-26 17:56:40
 */
@Service("payOrderService")
public class PayOrderServiceImpl implements PayOrderService {
    @Resource
    private PayOrderDao payOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PayOrder queryById(Long id) {
        return this.payOrderDao.queryById(id);
    }

    @Override
    public PayOrder queryByPayNo(String payNo) {
        return payOrderDao.queryByPayNo(payNo);
    }

    /**
     * 分页查询
     *
     * @param payOrder    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<PayOrder> queryByPage(PayOrder payOrder, PageRequest pageRequest) {
        long total = this.payOrderDao.count(payOrder);
        return new PageImpl<>(this.payOrderDao.queryAllByLimit(payOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param payOrder 实例对象
     * @return 实例对象
     */
    @Override
    public PayOrder insert(PayOrder payOrder) {
        this.payOrderDao.insert(payOrder);
        return payOrder;
    }

    /**
     * 修改数据
     *
     * @param payOrder 实例对象
     * @return 实例对象
     */
    @Override
    public PayOrder update(PayOrder payOrder) {
        this.payOrderDao.update(payOrder);
        return this.queryById(payOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.payOrderDao.deleteById(id) > 0;
    }

    @Override
    public String createOrder(CreateOrderRequest createOrderRequest) {

        Order order = PayOrderMapping.INSTANCE.toOrder(createOrderRequest);
        String content = JSONUtil.toJsonStr(order);
        PayOrder payOrderDO = new PayOrder();
        payOrderDO.setOrderNo(createOrderRequest.getOrderNo());
        payOrderDO.setUserId(createOrderRequest.getUserId());
        payOrderDO.setContent(content);
        payOrderDO.setGmtCreated(new Date());
        payOrderDO.setGmtModified(new Date());
        payOrderDO.setPayType(createOrderRequest.getPayType());
        payOrderDO.setAmount(createOrderRequest.getAmount());
        String payNo = generatePayNo(payOrderDO);
        payOrderDO.setPayNo(payNo);
        try {
            int res = payOrderDao.insert(payOrderDO);
            assert res > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return payNo;
    }

    private String generatePayNo(PayOrder payOrderDO) {
        return IdUtil.simpleUUID();
    }
}
