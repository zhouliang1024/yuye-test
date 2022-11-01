package com.example.yuye.biz.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.example.yuye.biz.dto.TransferContext;
import com.example.yuye.biz.service.AccountService;
import com.example.yuye.biz.service.BalanceService;
import com.example.yuye.biz.service.PayOrderService;
import com.example.yuye.biz.service.TransferManager;
import com.example.yuye.dal.dao.AccountDao;
import com.example.yuye.dal.dao.BalanceDao;
import com.example.yuye.dal.entity.Account;
import com.example.yuye.dal.entity.Balance;
import com.example.yuye.dal.entity.PayOrder;
import com.example.yuye.domain.order.Order;
import com.example.yuye.domain.transfer.Transfer;
import com.example.yuye.domain.transfer.TransferAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @author zhouliang
 * @date 2022/7/27 2:04 PM
 */
@Service
@Slf4j
public class TransferManagerImpl implements TransferManager {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BalanceService balanceService;

    @Autowired
    private PayOrderService payOrderService;

    @Override
    public boolean transaction(TransferContext transferContext) {
        List<Account> accounts = transferContext.getAccounts();
        assert CollectionUtil.isNotEmpty(accounts);
        List<Balance> balances = transferContext.getBalances();
        assert CollectionUtil.isNotEmpty(balances);
        try {
            log.info("accounts{}|balances{}", JSONUtil.toJsonStr(accounts), JSONUtil.toJsonStr(balances));
            accounts.forEach(account -> accountService.update(account));
            balances.forEach(balance -> balanceService.insert(balance));
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean transactionByPayNo(String payNo) {
        PayOrder payOrder = payOrderService.queryByPayNo(payNo);
        assert Objects.nonNull(payOrder);
        TransferContext transferContext = buildTransferContext(payOrder);
        return this.transaction(transferContext);
    }

    private TransferContext buildTransferContext(PayOrder payOrder) {
        String content = payOrder.getContent();
        Order order = JSONUtil.toBean(content, Order.class);
        Integer accountType = payOrder.getPayType() == 1 ? 1 : 0;
        Account accountFrom = accountService.queryAccount(payOrder.getUserId(), accountType);
        TransferAccount fromAccount = new TransferAccount();
        fromAccount.setAccountId(accountFrom.getId());
        fromAccount.setUserId(payOrder.getUserId());
        fromAccount.setAccountType(accountType);
        fromAccount.setAccountAmount(accountFrom.getAmount());
        Account accountTo = accountService.queryAccount(order.getToUserId(), 3);
        TransferAccount toAccount = new TransferAccount();
        toAccount.setAccountId(accountTo.getId());
        toAccount.setUserId(order.getToUserId());
        //3是货款账户
        toAccount.setAccountType(3);
        toAccount.setAccountAmount(accountTo.getAmount());
        Transfer transfer = new Transfer(payOrder.getAmount(), order.getFee(), order.getSubsidy());
        return TransferContext
                .builder()
                .fromAccount(fromAccount)
                .transfer(transfer)
                .toAccount(toAccount)
                .payNo(payOrder.getPayNo())
                .build();
    }
}
