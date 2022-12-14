package com.example.yuye.biz.component.annotation;

/**
 * @author zhouliang
 * @date 2022/8/17 3:24 PM
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Operate Log 的自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpLog {


    /**
     * 业务对象名称，如订单、库存、价格
     *
     * @return
     */
    public String opItem();

    /**
     * 业务对象编号表达式，描述了如何获取订单号的表达式
     *
     * @return
     */
    public String opItemIdExpression();
}
