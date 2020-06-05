package com.xiaoyingge.sort.heap;

import com.xiaoyingge.common.AbstractSort;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/5 19:05
 */
public class BigRoot extends AbstractSort {

    //左节点找根就是/2 可节点找根 就是/2-1
    public static void main (String[] args) {
        int[] arr = {5, 32, 6, 6, 7, 1, 3, 2, 2, 5, 6, 7};
        new BigRoot().heapLoop(arr);
    }

    public void heapLoop (int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            int prev = i >> 1;
            if (prev > 0 && arr[i - 1] > arr[prev - 1]) {
                swap(arr, i - 1, prev - 1);
            }
        }

    }

}
