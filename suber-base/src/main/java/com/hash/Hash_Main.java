package com.hash;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangyongchao
 * @date 2019/2/18  9:49
 */
public class Hash_Main {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        HashClass hashClass = new HashClass();
        System.out.println(hashClass.hashCode());
        countDownLatch.await();

    }
}


/**
 * 在有些情况下，程序设计者在设计一个类的时候为需要重写equals方法
 *
 * hashCode 和地址有关  但不是地址。
 * hashCode 相同，equals方法可能不同。
 *
 * hashCode的作用，主要是配合散列集合发挥作用，减少equals方法的调用。
 */
class HashClass{

    private Integer integer;

    public HashClass() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}