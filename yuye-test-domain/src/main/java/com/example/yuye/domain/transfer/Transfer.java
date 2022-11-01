package com.example.yuye.domain.transfer;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouliang
 * @date 2022/7/27 11:23 AM
 */
@Data
@NoArgsConstructor
public class Transfer {
    private Long changeAmount;
    private Long amount;

    private Long afterBalance;
    private Long fee;
    private Long subsidy;



    public Transfer( Long changeAmount, Long fee, Long subsidy) {
        this.changeAmount = changeAmount;
        this.fee = fee;
        this.subsidy = subsidy;
    }

    /**
     * 校验金额
     *
     * @return
     */
    public boolean checkBalance(boolean income,Long accountAmount) {
        boolean flag = true;
        if (accountAmount != null && changeAmount != null && afterBalance != null) {
            flag = afterBalance == accountAmount + getAmount();
        }
        return flag;
    }

    /**
     * 获取账户金额
     *
     * @return
     */
    public Long getAmount(boolean income) {
        if (fee == null) {
            fee = 0L;
        }
        if (subsidy == null) {
            subsidy = 0L;
        }
        if ((changeAmount + subsidy) < fee) {
            throw new RuntimeException("fee exceed changeAmount");
        }
        //收款方支付费用  付款方增加补贴
        Long money = income? changeAmount - fee : -changeAmount  + subsidy;
        if (this.amount ==null){
            this.amount =money;
        }
        return money;
    }

    /**
     * 获取动账后账户金额
     *
     * @return
     */
    public Long getAfterBalance(boolean income ,Long accountAmount) {
        Long money = accountAmount + getAmount(income);
        if (this.afterBalance ==null){
            this.afterBalance =money;
        }
        return money;
    }

}
