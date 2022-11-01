package com.example.yuye.biz.dto;

import com.example.yuye.dal.entity.Account;
import com.example.yuye.dal.entity.Balance;
import com.example.yuye.domain.transfer.Transfer;
import com.example.yuye.domain.transfer.TransferAccount;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Transfer context.
 *
 * @author zhouliang
 * @date 2022 /7/27 2:01 PM
 */
@Data
@Builder
public class TransferContext {
    private String payNo;
    private TransferAccount fromAccount;
    private Transfer transfer;
    private TransferAccount toAccount;


    /**
     * Get accounts list.
     *
     * @return the list
     */
    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<>(2);
        Account fromAccountDO = new Account();
        fromAccountDO.setId(fromAccount.getAccountId());
        fromAccountDO.setUserId(fromAccount.getUserId());
        fromAccountDO.setAmount(transfer.getAfterBalance(false, fromAccount.getAccountAmount()));
        fromAccountDO.setType(fromAccount.getAccountType());
        fromAccountDO.setGmtCreated(new Date());
        fromAccountDO.setGmtModified(new Date());
        accounts.add(fromAccountDO);

        Account toAccountDO = new Account();
        toAccountDO.setId(toAccount.getAccountId());
        toAccountDO.setUserId(toAccount.getUserId());
        toAccountDO.setAmount(transfer.getAfterBalance(true,toAccount.getAccountAmount()));
        toAccountDO.setType(toAccount.getAccountType());
        toAccountDO.setGmtCreated(new Date());
        toAccountDO.setGmtModified(new Date());
        accounts.add(toAccountDO);
        return  accounts;
    }

    /**
     * Get balances list.
     *
     * @return the list
     */
    public List<Balance> getBalances(){
        List<Balance> balances = new ArrayList<>(2);
        Balance fromBalance = new Balance();
        fromBalance.setPayNo(payNo);
        fromBalance.setType(fromAccount.getAccountType());
        fromBalance.setUserId(fromAccount.getUserId());
        fromBalance.setBeforeBalance(fromAccount.getAccountAmount());
        fromBalance.setAmount(transfer.getAmount(false));
        fromBalance.setAfterBalance(transfer.getAfterBalance(false,fromAccount.getAccountAmount()));
        fromBalance.setFee(0L);
        fromBalance.setSubsidy(transfer.getSubsidy());
        fromBalance.setRelationUserId(toAccount.getUserId());
        fromBalance.setRelationAccountType(toAccount.getAccountType());
        fromBalance.setGmtCreated(new Date());
        fromBalance.setGmtModified(new Date());
        balances.add(fromBalance);

        Balance toBalance = new Balance();
        toBalance.setPayNo(payNo);
        toBalance.setType(toAccount.getAccountType());
        toBalance.setUserId(toAccount.getUserId());
        toBalance.setBeforeBalance(toAccount.getAccountAmount());
        toBalance.setAmount(transfer.getAmount(true));
        toBalance.setAfterBalance(transfer.getAfterBalance(true,toAccount.getAccountAmount()));
        toBalance.setFee(transfer.getFee());
        toBalance.setSubsidy(0L);
        toBalance.setRelationUserId(fromAccount.getUserId());
        toBalance.setRelationAccountType(fromAccount.getAccountType());
        toBalance.setGmtCreated(new Date());
        toBalance.setGmtModified(new Date());
        balances.add(toBalance);
        return balances;
    }

}
