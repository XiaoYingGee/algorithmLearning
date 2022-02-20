package com.xiaoyingge.basic.class01;

import com.xiaoyingge.util.NumUtil;
import java.util.Arrays;

/**
 * 插入排序，即将数字插入到需要的位置，和打牌一样
 *
 * @author XiaoYingGee
 * @date 2022/2/20 14:35
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(100);
        int[] test = NumUtil.copy(arr);
        sort(arr);
        Arrays.sort(test);
        NumUtil.compare(arr, test);
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumUtil.swap(arr, j, j + 1);
            }
        }
    }
}
