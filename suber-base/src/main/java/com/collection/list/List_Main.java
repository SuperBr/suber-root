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
        /**
         *实现了Queue，Deque：双端队列。
         *
         *LinkedList底层使用的双向链表结构
         */
        List linkedList = new LinkedList( );
        /**
         * 【】在根据索引查找结点时，会有一个小优化，结点在前半段则从头开始遍历，在后半段则从尾开始遍历，这样就保证了只需要遍历最多一半结点就可以找到指定索引的结点。
         */
        linkedList.get(1);

        /**
         * 【Vector是线程安全的】
         * 【数组实现，可以理解为arrayList的同步版本】
         */
        List vector = new Vector();
        /**
         *FILO 先进后出
         *继承了vector
         */
        List stack = new Stack();


        ArrayList arrayList1 = new ArrayList();

        LinkedList linkedList1 = new LinkedList();

        linkedList1.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        Collections.sort(new ArrayList());

        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        Arrays.sort(new int[12]);

    }
}
