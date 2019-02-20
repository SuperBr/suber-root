package com.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wangyongchao
 * @date 2019/2/19  16:55
 */
public class Set_Main {

    public static void main(String[] args) {


        /**
         * A:前三个构造函数，即访问权限为public类型的构造函数均是以HashMap作为实现。而以LinkedHashMap作为实现的构造函数的访问权限是默认访问权限，即包内访问权限。
         即：在java编程中，通过new创建的HashSet对象均是以HashMap作为实现基础。只有在jdk中java.util包内的源代码才可能创建以LinkedHashMap作为实现的HashSet(LinkedHashSet就是通过封装一个以LinkedHashMap为实现的HashSet来实现的)。
         B:只有包含三个参数的构造函数才是采用的LinkedHashMap作为实现。


         HashSet中可以出现一个为null元素。
         ---------------------
         */
        Set set1 = new HashSet();

        /**
         *LinkedHashSet是通过继承HashSet，然后基于LinkedHashMap进行实现的。
         *
         * 所以LinkedHashSet除了具有HashSet的功能外，还能保证元素按照加入顺序进行排序。
         */
        Set set = new LinkedHashSet();


        Set set2 = new TreeSet();


    }
}
