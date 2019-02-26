package com.dataStructure;

import org.junit.Test;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * @author wangyongchao
 * @date 2019/2/25  9:43
 */
public class Search_Test {

    /**
     * 顺序查找
     *
     * @param arr
     * @return
     */
    public int SequelSearch(int[] arr) {


        return 0;
    }

    @Test
    public void BinarySearch_Test() {
        int[] a = {1, 8, 15, 96, 123, 856, 996,1025};
        System.out.println(BinarySearch(a, 0, a.length-1, 15));

    }

    /**
     * 二分查找
     *
     * @param arr
     * @return
     */
    public int BinarySearch(int[] arr, int left, int right, int num) {

        if (left >right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == num) {
            return mid;
        } else if (arr[mid] > num) {
            return BinarySearch(arr, left, mid-1, num);
        } else {
            return BinarySearch(arr, mid+1, right, num);
        }

    }

   public int  insert_search(int[] arr, int left, int right, int num) {
       if (left >right) {
           return -1;
       }
       //low+(high-low)*(b-a[low])/(a[high]-a[low])
       //int mid = (left + right) / 2;
       int mid = (right - left) * (num - arr[left]) / (arr[right] - arr[left]);
       if (arr[mid] == num) {
           return mid;
       } else if (arr[mid] > num) {
           return BinarySearch(arr, left, mid-1, num);
       } else {
           return BinarySearch(arr, mid+1, right, num);
       }
    }
}
