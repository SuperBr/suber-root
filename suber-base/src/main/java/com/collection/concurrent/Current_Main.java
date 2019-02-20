package com.collection.concurrent;

import java.util.concurrent.*;

public class Current_Main {

    public static void main(String[] args) {
        /**
         * hashMap的替代
         */
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        /**
         * arrayList 的并发替代
         */
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        /**
         * arraySet的并发代替
         */
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();

        /**
         * skipList 跳表 ，天然有序。  TreeMap的替代
         */
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();

        /**
         * 这个并发集合类不仅支持排序功能，还不允许重复的元素
         */
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();

        /**
         *
         * linkedList的并发替代
         *这个并发集合类提供了并发环境的队列操作。

         poll()当没有获取到数据时返回null，如果有数据则一处表头并将表头数据返回。
         element()当没有获取到数据时抛NoSuchElementException异常，如果有数据则返回表头数据。
         peek()当没有获取导数据是返回null，获取到数据时则不移除表头，并将表头数据返回。
         */
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

    }
}
