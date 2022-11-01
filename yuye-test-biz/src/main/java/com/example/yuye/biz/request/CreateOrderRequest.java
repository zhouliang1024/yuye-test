package com.example.yuye.biz.request;


import lombok.Data;

/**
 * @author zhouliang
 * @date 2022/7/27 10:12 AM
 */
@Data
public class CreateOrderRequest extends BaseRequest {
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


    //=================================================//

    /**
     * 订单金额 分
     */
    private Long amount;

    /**
     * 支付用户Id
     */
    private String userId;
    /**
     * 支付类型
     */
    private Integer payType;
}
