package com.example.yuye.biz.service;

import com.example.yuye.biz.dto.TransferContext;

/**
 * @author zhouliang
 * @date 2022/7/27 2:03 PM
 */
public interface TransferManager {

    boolean transaction(TransferContext transferContext);

    boolean transactionByPayNo(String payNo);
}
