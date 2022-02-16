package com.e.dxy.leetcode.easy.sort;


/**
 * <p></p>
 *
 * @author omgzui
 * @date 2/16/22 10:06 PM
 */
public class Sort01 {
    // O(n^2)

    // 冒泡排序
    public void bubbleSort(int[] arr){
        int n = arr.length;

        if (n <= 1){
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

    // 插入排序
    public void insertSort(int[] arr){

    }

    // 选择排序
    public void selectSort(int[] arr){

    }

}
