package com.reentrantlock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyongchao
 * @date 2019/2/26  11:09
 */
public class Reentrantlock_Test {

    Lock lock = new ReentrantLock();
    Condition condition=lock.newCondition();

    @Test
    public void reentrantlock_Test() throws InterruptedException {
        try{
            lock.lock();
            condition.await();

        }finally {
            lock.unlock();
        }

    }
}
