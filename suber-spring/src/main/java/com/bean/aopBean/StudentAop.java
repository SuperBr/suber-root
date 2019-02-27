package com.bean.aopBean;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Aspect
@Component("aop")
public class StudentAop {

    @Pointcut("execution( * com.bean.*.*(..))")
    public void point() {


    }
    @After("point()")
    public void after() {
      System.out.println("bean aop");
    }
}
