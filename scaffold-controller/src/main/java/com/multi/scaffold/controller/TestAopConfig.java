package com.multi.scaffold.controller;

import com.multi.scaffold.service.impl.AfterService;
import com.muti.scaffold.MethodPointCut;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: David Chan
 * @date 2020-12-26
 */
@Aspect
@Slf4j
@Component
public class TestAopConfig {
    /**
     * 校验参数是否为SPEL
     */
    private static final String PARAM_REGEX = "^#.*.$";

    @Autowired
    private AfterService afterService;

    @Pointcut(value = "@annotation(methodPointCut)")
    public void pointcut(MethodPointCut methodPointCut) {
    }

    @Before(value = "pointcut(methodPointCut)", argNames = "joinPoint,methodPointCut")
    public void before(JoinPoint joinPoint, MethodPointCut methodPointCut) {
        log.info("Before method :{}", joinPoint.getSignature());
    }

    @Async
    @After(value = "pointcut(methodPointCut)", argNames = "joinPoint,methodPointCut")
    public void after(JoinPoint joinPoint, MethodPointCut methodPointCut) {
        String businessIdSped = methodPointCut.businessId();
        String businessNameSpel = methodPointCut.businessName();
        if (!businessIdSped.matches(PARAM_REGEX) || !businessNameSpel.matches(PARAM_REGEX)) {
            return;
        }
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String[] paraNameArr = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        if (paraNameArr == null) {
            return;
        }
        StandardEvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < paraNameArr.length; i++) {
            context.setVariable(paraNameArr[i], joinPoint.getArgs()[i]);
        }
        String id = new SpelExpressionParser().parseExpression(businessIdSped).getValue(context, String.class);
        String name = new SpelExpressionParser().parseExpression(businessNameSpel).getValue(context, String.class);
        afterService.sync(id, name);
    }
}
