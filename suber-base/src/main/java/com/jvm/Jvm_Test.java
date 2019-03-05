package com.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyongchao
 * @date 2019/2/26  16:18
 */
public class Jvm_Test {




    /**
     * -Xms20m -Xmx20m jvm
     * -Xmn15 新生代大小
     * -Xss10k
     * -XXThreadStackSize:2
     * -XX:PrintGCDetails
     * -XX:SurvivorRatio
     * -XX:+HeapDumpOnOutOfMemoryError
     * -XX:HeapDumpPath:./
     *
     * -XX:+PrintGCTimeStamps、
     * -XX:+PrintGCApplicationStoppedTime
     * -XX:+PrintCommonLineFlags
     * -XX:+PrintFlagFinal
     * -XX:+UseConcMarkSweepGC
     * @param args
     */
    public static void main(String[] args){

        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : beans) {
            System.out.println(bean.getName());
        }


        List<Integer> integerList = new ArrayList<>();
        while (true) {
            integerList.add(new Integer(1));
            System.out.println(integerList.size());
        }
      //  Method();

    }

    public static void Method() {
        System.out.println();


    }
}
