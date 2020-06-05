package com.xiaoyingge.sort.heap;

import com.xiaoyingge.common.AbstractSort;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/5 23:53
 */
public class HeapSort extends AbstractSort {

    //左节点找根就是/2 可节点找根 就是/2-1
    public static void main (String[] args) {
        int[] arr = {5, 4, 6, 6, 7, 1, 3, 2, 2, 5, 6, 32};
        new HeapSort().heapLoop(arr);
    }

    public void heapLoop (int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            int temp = i;
            while ((temp >> 1) > 0 && arr[temp - 1] > arr[(temp >> 1) - 1]) {
                swap(arr, temp - 1, (temp >> 1) - 1);
                temp >>= 1;
            }
        }

    }
}
