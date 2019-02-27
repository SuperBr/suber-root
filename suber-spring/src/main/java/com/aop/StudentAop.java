package com.aop;


import org.aspectj.lang.annotation.Aspect;

/**
 * @author wangyongchao
 * @date 2019/2/27  17:23
 */


public class StudentAop {

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
