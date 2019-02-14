package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangyongchao
 * @date 2019/2/14  14:46
 */
public class JDKProxy {


    public static void main(String[] args) {
        ProxyInterfaceA proxyInterfaceA= (ProxyInterfaceA) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                new Class[]{ProxyInterfaceA.class}, new JDKDynamicProxy(()->{
                     System.out.println("hi lius!");

                }));

        proxyInterfaceA.methodA();
    }


    interface ProxyInterfaceA {

        void methodA();


    }

    static class JDKDynamicProxy implements InvocationHandler {
        private ProxyInterfaceA object;

        public JDKDynamicProxy(ProxyInterfaceA object) {
            this.object = object;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("method:" + method.getName());
            object.methodA();
            return null;
        }
    }

}
