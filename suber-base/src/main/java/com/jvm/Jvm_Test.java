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
     *
     *
     *
     *   java  -Xmx3550m  -Xms3550m  -Xss128k  -XX:NewRatio=4  -XX:SurvivorRatio=4  -XX:MaxPermSize=16m  -XX:MaxTenuringThreshold=0

     -XX:NewRatio=4：设置年轻代（包括Eden和两个Survivor区）与年老代的比值（除去持久代）。设置为4，则年轻代与年老代所占比值为1:4，年轻代占整个堆栈的1/5。

     -XX:SurvivorRatio=8：设置年轻代中Eden区与Survivor区的大小比值。设置为4，则两个Survivor区与一个Eden区的比值为2:4，一个Survivor区占整个年轻代的1/6。

     -XX:MaxPermSize=16m：设置持久代大小为16m。

     -XX:MaxTenuringThreshold=0：设置垃圾最大年龄。如果设置为0的话，则年轻代对象不经过Survivor区，直接进入年老代。对于年老代比较多的应用，可以提高效率。如果此值设置为一个较大值，则年轻代对象会在Survivor区进行多次复制，这样可以增加对象在年轻代的存活时间，增加在年轻代被回收的概率。
     *
     *
     *
     *
     * -XX:+UseParallelGC：选择垃圾收集器为并行收集器。此配置仅对年轻代有效。即上述配置下，年轻代使用并发收集，而年老代仍旧使用串行收集。
     -XX:+ParallelGCThreads=20：配置并行收集器的线程数，即：同时多少个线程一起进行垃圾回收。此值最好配置与处理器数目相等。
     java  -Xmx3550m  -Xms3550m  -Xmn2g  -Xss128k  -XX:+UseParallelGC  -XX:ParallelGCThreads=20 -XX:+UseParallelOldGC
     -XX:+UseParallelOldGC：配置年老代垃圾收集方式为并行收集。JDK6.0支持对年老代并行收集。
     java  -Xmx3550m  -Xms3550m  -Xmn2g  -Xss128k  -XX:+UseParallelGC  -XX:MaxGCPauseMillis=100
     -XX:MaxGCPauseMillis=100：设置每次年轻代垃圾回收的最长时间，如果无法满足此时间，JVM会自动调整年轻代大小，以满足此值。
     java  -Xmx3550m  -Xms3550m  -Xmn2g  -Xss128k  -XX:+UseParallelGC  -XX:MaxGCPauseMillis=100  -XX:+UseAdaptiveSizePolicy
     -XX:+UseAdaptiveSizePolicy:设置此选项后，并行收集器会自动选择年轻代区大小和相应的Survivor区比例，以达到目标系统规定的最低响应时间或者收集频率等，此值建议使用并行收集器时，一直打开。
     *
     *
     *
     * java  -Xmx3550m  -Xms3550  -Xmn2g  -Xss128k  -XX:ParallelGCThreads=20  -XX:+UseConcMarkSweepGC  -XX:+UseParNewGC
     -XX:+UseConcMarkSweepGC：设置年老代为并发收集。测试中配置这个以后，-XX:NewRatio=4的配置失效了，原因不明。所以，此时年轻代大小最好用-Xmn设置。
     -XX:+UseParNewGC：设置年轻代为并行收集。可与CMS收集同时使用。JDK5.0以上，JVM会根据系统配置自行设置，所以无需再设置此值。
     java  -Xmx3550m  -Xms3550  -Xmn2g  -Xss128k  -XX:+UseConcMarkSweepGC  -XX:CMSFullGCsBeforeCompaction=5  -XX:+UseCMSCompactAtFullCollection
     -XX:CMSFullGCsBeforeCompaction：由于并发收集器不对内存空间进行压缩、整理，所以运行一段时间后会产生“碎片”，使得运行效率降低。此值设置运行多少次GC以后对内存空间进行压缩、整理。
     -XX:+UseCMSCompactAtFullCollection：打开对年老代的压缩。可能会影响性能，但是可以消除碎片。
     *
     *
     *
     *
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
