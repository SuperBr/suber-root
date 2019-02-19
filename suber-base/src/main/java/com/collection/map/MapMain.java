package com.collection.map;

import sun.reflect.generics.tree.Tree;

import javax.swing.table.TableCellEditor;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangyongchao
 * @date 2019/2/15  9:34
 */
public class MapMain {

    /**
     * 数组：采用一段连续的存储单元来存储数据。对于指定下标的查找，时间复杂度为O(1)；
     * 通过给定值进行查找，需要遍历数组，逐一比对给定关键字和数组元素，时间复杂度为O(n)，
     * 当然，对于有序数组，则可采用二分查找，插值查找，斐波那契查找等方式，可将查找复杂度提高为O(logn)；
     * 对于一般的插入删除操作，涉及到数组元素的移动，其平均复杂度也为O(n)
     * <p>
     * 　　线性链表：对于链表的新增，删除等操作（在找到指定操作位置后），仅需处理结点间的引用即可，时间复杂度为O(1)，而查找操作需要遍历链表逐一进行比对，复杂度为O(n)
     * <p>
     * 　　二叉树：对一棵相对平衡的有序二叉树，对其进行插入，查找，删除等操作，平均复杂度均为O(logn)。
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 相比上述几种数据结构，在哈希表中进行添加，删除，查找等操作，性能十分之高，不考虑哈希冲突的情况下，仅需一次定位即可完成，时间复杂度为O(1)，接下来我们就来看看哈希表是如何实现达到惊艳的常数阶O(1)的。
         *
         *【hash算法】 (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
         *             取模：（n-1)&h
         *
         *           *当 lenth = 2n 时，X % length = X & (length - 1)
         *
         *
         *
         *【tableSizeFor】
         *  static final int tableSizeFor(int cap) {
         int n = cap - 1;
         n |= n >>> 1;
         n |= n >>> 2;
         n |= n >>> 4;
         n |= n >>> 8;
         n |= n >>> 16;
         return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
         }



         创建 HashMap 时未指定初始容量情况下的默认容量
         static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

         　//HashMap 的最大容量
         static final int MAXIMUM_CAPACITY = 1 << 30;

         //HashMap 默认的装载因子,当 HashMap 中元素数量超过 容量*装载因子 时，进行　resize()　操作
         static final float DEFAULT_LOAD_FACTOR = 0.75f;

         //用来确定何时将解决 hash 冲突的链表转变为红黑树
         static final int TREEIFY_THRESHOLD = 8;

         // 用来确定何时将解决 hash 冲突的红黑树转变为链表
         static final int UNTREEIFY_THRESHOLD = 6;
         当需要将解决 hash 冲突的链表转变为红黑树时，需要判断下此时数组容量，若是由于数组容量太小（小于　MIN_TREEIFY_CAPACITY　）导致的 hash 冲突太多，则不进行链表转变为红黑树操作，转为利用　resize() 函数对　hashMap 扩容
         static final int MIN_TREEIFY_CAPACITY = 64;



         元素在重新计算hash之后，因为n变为2倍，那么n-1的mask范围在高位多1bit(红色)，因此新的index就会发生这样的变化：

         因此，我们在扩充HashMap的时候，只需要看看原来的hash值新增的那个bit是1还是0就好了，是0的话索引没变，是1的话索引变成“原索引+oldCap”


         jdk 1.7 中 resize时 用了头插入法，多线程会出现循环链。

         jdk 1.8 中 ：尾插入法 ，多线程下不会出现死循环。

         - 1 先判断是否能扩容。
         - 2 开始进行Node节点重新分配。先重新建立一个数组。
         - 3 开始遍历旧的数组。
         - 4 如果在该数组索引下有节点。
         - 5 先将旧数组索引设置成Null,等cg回收
         - 6 判断该Node节点有没有成链，如果是单一节点。直接计算新的索引存放
         - 7 判断该node节点是否是红黑树。如果是红黑树那就进行split（）方法。
         - 8 经过两次判断，可以确定该node节点是链表。
         - 9 新键两个Node节点，相当于要建立两个链表，一个链表是继续存放在原本的数组索引下，一个是存放在新的数组索引下
         - 10 判断Bit位是否为0
         - 11 一个链表放在原本的数组索引位置
         - 12 另一个链表放在原索引位置+原容量

         【单向链表】

         */
        Map hashMap = new HashMap<>();

        //Map.Entry.comparingByKey();

        /**
         * key 不能为空
         *
         * key 必须实现 Comparable
         *
         *
         *
         *
         * 【3.1 SortedMap接口】
         public interface SortedMap<K,V> extends Map<K,V> {
         //返回用于对键的进行排序的比较器，如果此映射使用其键的自然排序，则为null
         Comparator<? super K> comparator();
         //返回从fromKey（包括）到toKey（不包括）之间的map
         SortedMap<K,V> subMap(K fromKey, K toKey);
         //返回小于toKey的map
         SortedMap<K,V> headMap(K toKey);
         //返回大于或等于fromKey的map
         SortedMap<K,V> tailMap(K fromKey);
         //返回map中第一个（最低）键
         K firstKey();
         //返回map中最后一个（最高）键
         K lastKey();
         Set<K> keySet();
         Collection<V> values();
         Set<Map.Entry<K, V>> entrySet();

         【NavigableMap】
         //返回键小于且最接近Key（不包含等于）的键值对，没有返回null
         Map.Entry<K,V> lowerEntry(K key);
         //返回小于且最接近（不包含等于）Key的键，没有返回null
         K lowerKey(K key);
         //返回键小于且最接近（包含等于）Key的键值对，没有返回null
         Map.Entry<K,V> floorEntry(K key);
         //返回小于且最接近（包含等于）Key的键，没有返回null
         K floorKey(K key);
         //返回大于且最接近（包含等于）给定key的键值对，没有返回null
         Map.Entry<K,V> ceilingEntry(K key);
         //同上
         K ceilingKey(K key);
         //返回大于且最接近（不包含等于）给定key的键值对
         Map.Entry<K,V> higherEntry(K key);
         //同上
         K higherKey(K key);
         //返回第一个Entry
         Map.Entry<K,V> firstEntry();
         //返回最后一个Entry
         Map.Entry<K,V> lastEntry();
         //移除并返回第一个Entry
         Map.Entry<K,V> pollFirstEntry();
         //同上
         Map.Entry<K,V> pollLastEntry();
         //返回map中包含的映射关系的逆序视图
         NavigableMap<K,V> descendingMap();
         //返回map中包含的键的NavigableSet视图。 set的迭代器按key的升序
         NavigableSet<K> navigableKeySet();
         //逆序
         NavigableSet<K> descendingKeySet();
         //根据fromKey和toKey来返回子map，两个boolean参数用于是否包含该key
         NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
         K toKey,   boolean toInclusive);
         //返回小于（或等于,根据inclusive）toKey的map
         NavigableMap<K,V> headMap(K toKey, boolean inclusive);
         //返回大于（或等于,根据inclusive）fromKey的map
         NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);
         SortedMap<K,V> subMap(K fromKey, K toKey);
         SortedMap<K,V> headMap(K toKey);
         SortedMap<K,V> tailMap(K fromKey);

         */
        TreeMap<UserA, Object> treeMap = new TreeMap<UserA, Object>(new Comparator<UserA>() {
            @Override
            public int compare(UserA o1, UserA o2) {
                return 0;
            }
        });

        treeMap.put(null, new Object());


        Collections.sort(new ArrayList<UserA>(), (o1, o2) -> 1);

        /**
         * 双向链表，继承了hashMap
         *
         *  accessOrder默认为false，即按照插入顺序来连接，true则为按照访问顺序来连接
         *
         *  accessOrder=true:每当我get或者put一个已存在的数据，就会把这个数据放到双向链表的尾部，put一个新的数据也会放到双向链表的尾部。
         */
        Map linkedHashMap = new LinkedHashMap();


        /**
         *HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的分别。
         * 主要的区别有：线程安全性，同步(synchronization)，以及速度。

         HashMap几乎可以等价于Hashtable，除了HashMap是非synchronized的，并可以接受null(HashMap可以接受为null的键值(key)和值(value)，而Hashtable则不行)。
         HashMap是非synchronized，而Hashtable是synchronized，这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。Java 5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。
         另一个区别是HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。但这并不是一个一定发生的行为，要看JVM。这条同样也是Enumeration和Iterator的区别。
         由于Hashtable是线程安全的也是synchronized，所以在单线程环境下它比HashMap要慢。如果你不需要同步，只需要单一线程，那么使用HashMap性能要好过Hashtable。
         HashMap不能保证随着时间的推移Map中的元素次序是不变的。

         key: 不能为空。


         【hashTable】： Hashtable默认的初始大小为11，之后每次扩充，容量变为原来的2n+1
         */
        Map hashTable = new Hashtable();

        tableSizeFor(1000);


    }


    public static int tableSizeFor(int a) {
        a = a - 1;
        a |= a >>> 1;
        System.out.println(Integer.toBinaryString(a));
        a |= a >>> 2;
        System.out.println(Integer.toBinaryString(a));
        a |= a >>> 4;
        System.out.println(Integer.toBinaryString(a));
        a |= a >>> 8;
        System.out.println(Integer.toBinaryString(a));
        a |= a >>> 16;

        System.out.println(a);

        return a;
    }


    static class UserA implements Comparable {

        private Long id;

        public Long getId() {
            return id;
        }

        public UserA setId(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
