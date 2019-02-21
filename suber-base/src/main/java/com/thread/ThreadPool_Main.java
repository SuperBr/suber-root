package com.thread;

import java.util.concurrent.*;

public class ThreadPool_Main {


    /**
     * 线程池为线程生命周期开销问题和资源不足问题提供了解决方案。
     * 通过对多个任务重用线程，线程创建的开销被分摊到了多个任务上。
     * 其好处是，因为在请求到达时线程已经存在，所以无意中也消除了线程创建所带来的延迟。
     * 这样，就可以立即为请求服务，使应用程序响应更快。
     * 而且，通过适当地调整线程池中的线程数目，也就是当请求的数目超过某个阈值时，
     * 就强制其它任何新到的请求一直等待，直到获得一个线程来处理为止，从而可以防止资源不足。
     *
     *
     *
     *
     * ThreadPoolExecutor用一个int值得高3位表示线程池的运行状态，低29位表示线程池线程数量
     * @param args
     */
    public static void main(String[] args) {

        /**
         * SynchronousQueue
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


        /**
         * LinkedBlockingQueue
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /**
         * LinkedBlockingQueue
         */
        ExecutorService  singleThreadExecutor= Executors.newSingleThreadExecutor();

        /**
         *DelayedWorkQueue
         */
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(0,1,
                1000L, TimeUnit.DAYS,new PriorityBlockingQueue<>(),new ThreadPoolExecutor.AbortPolicy());

        pool.shutdown();

        pool.shutdownNow();







    }
}
