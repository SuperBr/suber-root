package com.cas;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wangyongchao
 * @date 2019/2/26  9:43
 */
public class Cas_Test {

    private AtomicInteger atomicInteger;


    AtomicStampedReference atomicStampedReference = new AtomicStampedReference(new Object(),1);


    private volatile Integer integer = new Integer(2);


    private static Unsafe unsafe;

    {
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cas_Test() {

        try {
           while (unsafe.compareAndSwapInt(integer, unsafe.objectFieldOffset(Integer.class.getDeclaredField("value")), 2, 4)){
               System.out.println(integer);
           }


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }


    public void atomic_Test() {
        atomicInteger.incrementAndGet();
    }
}
