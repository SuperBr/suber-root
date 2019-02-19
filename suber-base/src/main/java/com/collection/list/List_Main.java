package com.collection.list;

import java.util.*;

/**
 * @author wangyongchao
 * @date 2019/2/19  15:51
 */
public class List_Main {


    /**
     * (01) 对于需要快速插入，删除元素，应该使用LinkedList。
     * (02) 对于需要快速随机访问元素，应该使用ArrayList。
     * (03) 对于“单线程环境” 或者 “多线程环境，但List仅仅只会被单个线程操作”，此时应该使用非同步的类(如ArrayList)。
     * 对于“多线程环境，且List可能同时被多个线程操作”，此时，应该使用同步的类(如Vector)。
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 默认容量 10
         *
         * trimToSize：调整为实际大小
         *
         * grow方法会将当前数组的长度变为原来容量的1.5 倍
         */
        List arrayList = new ArrayList();

        List linkedList = new LinkedList();

        List vector = new Vector();

        List stack = new Stack();

    }
}
