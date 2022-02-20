package com.xiaoyingge.basic.class01;

import com.xiaoyingge.util.NumUtil;
import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author XiaoYingGee
 * @date 2022/2/20 14:30
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(100);
        int[] test = NumUtil.copy(arr);
        sort(arr);
        Arrays.sort(test);
        NumUtil.compare(arr, test);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    NumUtil.swap(arr, i, j);
                }
            }
        }
    }
}
