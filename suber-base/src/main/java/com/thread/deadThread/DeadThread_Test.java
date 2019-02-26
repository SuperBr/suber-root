package com.thread.deadThread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangyongchao
 * @date 2019/2/26  11:23
 */
public class DeadThread_Test {


    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        ExecutorService executors = Executors.newFixedThreadPool(3);
        executors.submit(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().isDaemon());
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "获得lock1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + "获得lock2");
                    }
                }


            }
        });


        executors.submit(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().isDaemon());
                    System.out.println(Thread.currentThread().getName() + "获得lock2");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + "获得lock1");
                    }
                }
            }
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



