package com.dataStructure;

import jdk.nashorn.internal.ir.ReturnNode;
import org.junit.Test;

import java.time.chrono.MinguoChronology;
import java.util.Arrays;

public class Sort_Main {
    /**
     * 8大排序 3大插入
     *
     * @param args
     */
    public static void main(String[] args) {


    }

    @Test
    public void merger2St_Test() {
        int a[] = {1, 5, 8, 9};
        int b[] = {2, 3, 6, 34};
        System.out.println(Arrays.toString(merger2St(a, b)));
    }


    @Test
    public void merger_sort_Test() {

        int a[] = {7, 1, 5, 8, 9, 6, 15};
        System.out.println(Arrays.toString(merger_sort(a, 0, a.length - 1)));
    }

    /**
     * 归并排序
     * <p>
     * 稳定
     *
     * @param old
     * @return 优点：始终都是O(nlogn）的时间复杂度
     */
    public static int[] merger_sort(int[] old, int left, int r) {
        if (left == r) {
            return old;
        }
        int mid = (left + r) / 2;

        merger_sort(old, left, mid);

        merger_sort(old, mid + 1, r);

        merger2St(old, left, mid, r);

        return old;
    }


    public static void merger2St(int[] arr, int left, int mid, int right) {

        int n[] = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            n[k++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }
        while (i <= mid) {
            n[k++] = arr[i++];
        }
        while (j <= right) {
            n[k++] = arr[j++];
        }
        int index = 0;
        while (left <= right) {
            arr[left++] = n[index++];

        }
    }

    public static int[] merger2St(int[] arrA, int[] arrB) {
        int a = arrA.length;
        int b = arrB.length;

        int n[] = new int[a + b];

        int i = 0, j = 0, k = 0;

        while (i < a && j < b) {
            n[k++] = arrA[i] > arrB[j] ? arrB[j++] : arrA[i++];
        }
        while (i < a) {
            n[k++] = arrA[i++];
        }
        while (j < b) {
            n[k++] = arrB[j++];
        }

        return n;
    }

    /**
     * 冒泡排序
     * N^2
     */
    public void Bubble_Sort() {


    }

    /**
     * 选择排序
     * <p>
     * 不稳定
     * <p>
     * <p>
     * 最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好
     */
    public void Selection_Sort() {


    }

    @Test
    public void Insertion_Sort_Test() {
        int a[] = {4, 48, 12, 7, 1, 5, 8, 9, 2};
        System.out.println(Arrays.toString(Insertion_Sort(a)));
    }

    /**
     * 插入排序
     * <p>
     * 稳定
     */
    public int[] Insertion_Sort(int[] arr) {

        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int tmp = arr[i];
            for (int j = i - 1; j >= -1; j--) {
                if (j >= 0 && tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = tmp;
                    break;
                }
            }

        }
        return arr;

    }

    @Test
    public void Shell_Sort_Test() {

        int a[] = {4, 48, 12, 7, 1, 5, 8, 9, 2};
        System.out.println(Arrays.toString(Shell_Sort(a)));
    }

    /**
     * 希尔排序
     * <p>
     * 不稳定
     * <p>
     * 希尔排序就是对直接插入排序的一个优化
     */
    public int[] Shell_Sort(int arr[]) {
        int increment = arr.length / 2;

        while (increment > 1) {
            for (int a = 0; a < arr.length; a++) {
                for (int b = a; b < arr.length - increment; b = b + increment) {

                    if (arr[a] > arr[a + increment]) {
                        int tmp = arr[a];
                        arr[a + increment] = arr[a];
                        arr[a] = tmp;
                    }
                }
            }
            increment = increment / 2;
        }
        return arr;
    }

}
