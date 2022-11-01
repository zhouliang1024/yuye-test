package com.example.yuye.domain.pay;

import lombok.Data;

/**
 * @author zhouliang
 * @date 2022/7/27 10:00 AM
 */
@Data
public class PayOrder {

    /**
     * 支付单号
     */
    private Long payNo;

    /**
     * 订单金额 分
     */
    private Long amount;

    /**
     * 支付用户Id
     */
    private Long userId;
    /**
     * 支付类型
     */
    private Integer payType;


}
