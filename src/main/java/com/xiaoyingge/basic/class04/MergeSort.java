package com.xiaoyingge.basic.class04;

import com.xiaoyingge.util.NumUtil;
import java.util.Arrays;

/**
 * 归并排序
 *
 * @author XiaoYingGee
 * @date 2022/2/19 17:57
 */
public class MergeSort {

    public static void main(String[] args) {

        for (int i = 0; i < 10_000; i++) {
            int[] arr = NumUtil.createRandomArray(1000);

            int[] test = NumUtil.copy(arr);
            process(arr, 0, arr.length - 1);
            Arrays.sort(test);
            NumUtil.compare(arr, test);
        }
    }

    private static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int length = right - left + 1;

        int[] help = new int[length];
        int helpIndex = 0;

        int leftIndex = left;

        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            help[helpIndex++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        while (leftIndex <= mid) {
            help[helpIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            help[helpIndex++] = arr[rightIndex++];
        }

        for (int i = 0; i < length; i++) {
            arr[left + i] = help[i];
        }
    }
}
