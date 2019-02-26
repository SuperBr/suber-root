package com.thread;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author wangyongchao
 * @date 2019/2/25  14:16
 */
public class Thread_test {


    @Test
    /**
     * callable  future futureTask
     */
    public void Callable() {
       /* Executors.callable(new Runnable() {
            @Override
            public void run() {


            }
        });*/
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Object> result = executor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);

                return new HashMap<String, Object>();
            }

        });

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void cyclicBarrier_Test() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int a=1;a<=10;a++) {
            executorService.submit(new Callable<Object>() {

                @Override
                public Object call() throws Exception {

                   // cyclicBarrier.
                    return null;
                }
            });
        }

    }


}
