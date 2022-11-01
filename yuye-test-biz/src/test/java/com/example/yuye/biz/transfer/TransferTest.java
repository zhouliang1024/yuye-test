package com.example.yuye.biz.transfer;

import com.example.yuye.biz.BaseTest;
import com.example.yuye.biz.dto.TransferContext;
import com.example.yuye.biz.service.TransferManager;
import com.example.yuye.domain.transfer.Transfer;
import com.example.yuye.domain.transfer.TransferAccount;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhouliang
 * @date 2022/7/27 2:44 PM
 */
@Slf4j
public class TransferTest extends BaseTest {

    @Resource
    private TransferManager transferManager;

    @Test
    void testTransaction() {
        TransferAccount fromAccount = new TransferAccount();
        fromAccount.setUserId("666");
        fromAccount.setAccountType(1);
        fromAccount.setAccountAmount(100L);
        TransferAccount toAccount = new TransferAccount();
        toAccount.setUserId("999");
        toAccount.setAccountType(3);
        toAccount.setAccountAmount(100L);
        Transfer transfer = new Transfer(10L, 0L, 0L);
        boolean transaction = transferManager.transaction(TransferContext
                .builder()
                .fromAccount(fromAccount)
                .transfer(transfer)
                .toAccount(toAccount)
                .payNo("20")
                .build()
        );
        assert transaction;
    }
}
