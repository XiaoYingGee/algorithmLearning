package com.xiaoyingge.basic.class01;

import com.xiaoyingge.util.NumUtil;
import java.util.Arrays;

/**
 * 选择排序 就是先找出最大或者最小的值，然后放到队首或者队尾的方法
 *
 * @author XiaoYingGee
 * @date 2022/2/20 14:19
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(100);
        int[] test = NumUtil.copy(arr);
        sort(arr);
        Arrays.sort(test);
        NumUtil.compare(arr, test);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            NumUtil.swap(arr, i, minIndex);
        }
    }
}
