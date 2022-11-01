package com.example.yuye.domain.transfer;

import lombok.Data;

/**
 * @author zhouliang
 * @date 2022/7/27 1:42 PM
 */
@Data
public class TransferAccount {

    private Long accountId;

    private String userId;

    private Integer accountType;

    private Long accountAmount;
}
