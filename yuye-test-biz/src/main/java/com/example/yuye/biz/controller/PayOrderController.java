package com.example.yuye.biz.controller;

import com.example.yuye.biz.request.CreateOrderRequest;
import com.example.yuye.biz.service.TransferManager;
import com.example.yuye.dal.entity.PayOrder;
import com.example.yuye.biz.service.PayOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * (PayOrder)表控制层
 *
 * @author makejava
 * @since 2022-07-26 17:56:35
 */
@RestController
@RequestMapping("payOrder")
public class PayOrderController {
    /**
     * 服务对象
     */
    @Resource
    private PayOrderService payOrderService;


    @Resource
    private TransferManager transferManager;

    /**
     * 分页查询
     *
     * @param payOrder    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<PayOrder>> queryByPage(PayOrder payOrder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.payOrderService.queryByPage(payOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<PayOrder> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.payOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param payOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<PayOrder> add(PayOrder payOrder) {
        return ResponseEntity.ok(this.payOrderService.insert(payOrder));
    }

    /**
     * 编辑数据
     *
     * @param payOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<PayOrder> edit(PayOrder payOrder) {
        return ResponseEntity.ok(this.payOrderService.update(payOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.payOrderService.deleteById(id));
    }

    /**
     * 创建订单
     *
     * @param createOrderRequest 实体
     * @return 新增结果
     */
    @PostMapping(value = "/create")
    public String createPayOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        //校验参数
        checkReq(createOrderRequest);
        //todo 幂等校验
        //创单
        String payNo = payOrderService.createOrder(createOrderRequest);
        return payNo;
    }

    @GetMapping(value = "/toPay")
    public String toPay(@RequestParam String payNo) {
        boolean res = transferManager.transactionByPayNo(payNo);
        return res ? "success" : "false";
    }

    private void checkReq(CreateOrderRequest createOrderRequest) {
        assert Objects.nonNull(createOrderRequest);
    }

}

