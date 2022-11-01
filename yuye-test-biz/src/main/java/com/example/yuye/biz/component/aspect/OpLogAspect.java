package com.example.yuye.biz.component.aspect;


import com.alibaba.druid.util.StringUtils;
import com.example.yuye.biz.component.annotation.OpLog;
import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * OpLog的切面处理类，用于通过注解获取日志信息，进行日志记录
 *
 * @author Hollis
 */
@Aspect
@Component
@Slf4j
public class OpLogAspect {


    @Autowired
    HttpServletRequest request;

    @Around("@annotation(com.example.yuye.biz.component.annotation.OpLog)")
    public Object log(ProceedingJoinPoint pjp) throws Exception {

        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
        OpLog opLog = method.getAnnotation(OpLog.class);

        Object response = null;

        try {
            // 目标方法执行
            response = pjp.proceed();
        } catch (Throwable throwable) {
            throw new Exception(throwable);
        }

        if (!StringUtils.isEmpty(opLog.opItemIdExpression())) {
            SpelExpressionParser parser = new SpelExpressionParser();
            Expression expression = parser.parseExpression(opLog.opItemIdExpression());

            EvaluationContext context = new StandardEvaluationContext();
            // 获取参数值
            Object[] args = pjp.getArgs();

            // 获取运行时参数的名称
            LocalVariableTableParameterNameDiscoverer discoverer
                    = new LocalVariableTableParameterNameDiscoverer();
            String[] parameterNames = discoverer.getParameterNames(method);

            // 将参数绑定到context中
            if (parameterNames != null) {
                for (int i = 0; i < parameterNames.length; i++) {
                    context.setVariable(parameterNames[i], args[i]);
                }
            }

            // 将方法的resp当做变量放到context中，变量名称为该类名转化为小写字母开头的驼峰形式
            if (response != null) {
                context.setVariable(
                        CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, response.getClass().getSimpleName()),
                        response);
            }

            // 解析表达式，获取结果
            String itemId = String.valueOf(expression.getValue(context));

            // 执行日志记录
            handle( opLog.opItem(), itemId);
        }

        return response;
    }


    private void handle( String opItem, String opItemId) {
        // 通过日志打印输出
        log.info( "opItem = " +opItem + ",opItemId = " +opItemId);
    }
}
