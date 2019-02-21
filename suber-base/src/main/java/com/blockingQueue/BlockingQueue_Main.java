package com.blockingQueue;

import java.util.concurrent.*;

/**
 * @author wangyongchao
 * @date 2019/2/21  15:16
 */
public class BlockingQueue_Main {


    /**
     * offer(anObject):表示如果可能的话,将anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,则返回true,否则返回false.（本方法不阻塞当前执行方法
     * <p>
     * 的线程）；
     * 　　（2）offer(E o, long timeout, TimeUnit unit)：可以设定等待的时间，如果在指定的时间内，还不能往队列中加入BlockingQueue，则返回失败。
     * <p>
     * 　　　　（3）put(anObject):把anObject加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断直到BlockingQueue里面有空间再继续.
     * <p>
     * 　　2. 获取数据
     * <p>
     * 　　　　（1）poll(time):取走BlockingQueue里排在首位的对象,若不能立即取出,则可以等time参数规定的时间,取不到时返回null;
     * <p>
     * 　　　　（2）poll(long timeout, TimeUnit unit)：从BlockingQueue取出一个队首的对象，如果在指定时间内，队列一旦有数据可取，则立即返回队列中的数据。否则知道时间
     * <p>
     * 超时还没有数据可取，返回失败。
     * <p>
     * 　　　　（3）take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到BlockingQueue有新的数据被加入;
     *
     * @param args
     */
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /**
         * 有界的  不存储元素
         */
        SynchronousQueue synchronousQueue = new SynchronousQueue();


        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronousQueue.put(new Object());
                        System.out.println("put ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronousQueue.take();
                        System.out.println("take ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();

        /**
         * 必须指点容量
         *
         * 放取同一个锁 lock
         */
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        /**
         * 公平性
         */
        new ArrayBlockingQueue(1, false);

        /**
         * 不指定大小时 为Integer.MAX
         *
         * put lock   tale lock
         */
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();



        LinkedBlockingQueue linkedBlockingQueue1 = new LinkedBlockingQueue(10);

        /**
         *无界的   需要实现Comparable
         *
         * 支持排序
         */
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(1);

        for (int a=0;a<10;a++) {
            priorityBlockingQueue.put(new String("111"));
            System.out.println("put a ele");
        }

        /**
         * 无界的
         */
        DelayQueue delayQueue = new DelayQueue();

        for (int a=0;a<100;a++) {
            delayQueue.put(new Delayed() {
                @Override
                public long getDelay(TimeUnit unit) {
                    return 0;
                }

                @Override
                public int compareTo(Delayed o) {
                    return 0;
                }
            });
            System.out.println("put a ele");
        }
    }
}
