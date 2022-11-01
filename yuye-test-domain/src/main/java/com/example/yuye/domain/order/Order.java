package com.example.yuye.domain.order;

import lombok.Data;

/**
 * @author zhouliang
 * @date 2022/7/27 9:59 AM
 */
@Data
public class Order {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * to用户id
     */
    private String toUserId ;

    /**
     * 过期时间 秒
     */
    private Integer expiredTime;

    /**
     * 描述:简明信息，如标题、备注
     */
    private String balanceMemo;

    /**
     * 描述：资源位名称+推广有效期
     */
    private String body;

    /**
     * 创单类型
     */
    private String unifiedOrderType;

    /**
     * 手续费 分
     */
    private Long fee = 0L;

    /**
     * 手续费类型 0付款方， 1收款方
     */
    private Integer feeType = 1 ;

    /**
     * 平台补贴 分
     */
    private Long subsidy = 0L;
}
