package com.example.yuye.dal.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Balance)实体类
 *
 * @author makejava
 * @since 2022-07-27 15:39:30
 */
public class Balance implements Serializable {
    private static final long serialVersionUID = -93062038962531915L;

    private Long id;

    private Date gmtCreated;

    private Date gmtModified;

    private String payNo;

    private String userId;

    private Integer type;

    private Long amount;

    private Long fee;

    private Long subsidy;

    private Long afterBalance;

    private Long beforeBalance;

    private String relationUserId;

    private Integer relationAccountType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Long getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Long subsidy) {
        this.subsidy = subsidy;
    }

    public Long getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(Long afterBalance) {
        this.afterBalance = afterBalance;
    }

    public Long getBeforeBalance() {
        return beforeBalance;
    }

    public void setBeforeBalance(Long beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    public String getRelationUserId() {
        return relationUserId;
    }

    public void setRelationUserId(String relationUserId) {
        this.relationUserId = relationUserId;
    }

    public Integer getRelationAccountType() {
        return relationAccountType;
    }

    public void setRelationAccountType(Integer relationAccountType) {
        this.relationAccountType = relationAccountType;
    }

}

