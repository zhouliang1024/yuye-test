package com.example.yuye.dal.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 账户(Account)实体类
 *
 * @author makejava
 * @since 2022-07-26 19:19:57
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 688494305662790796L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date gmtCreated;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 1为可用余额，2为佣金，3为临时余额账户,4为保证金账户，5为提现账户,  6为待结算账户
     */
    private Integer type;
    /**
     * 金额
     */
    private Long amount;


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

}

