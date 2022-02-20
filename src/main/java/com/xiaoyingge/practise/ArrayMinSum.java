package com.xiaoyingge.practise;

import com.xiaoyingge.util.NumUtil;

/**
 * 数组小和，即将小于自己的左侧的数相加，得到的结果即为单节点小和 如 【3，2，3】 3左边没数，它的小和为0 2左边有3，但是不比自己小，小和为0 3左边有2和3.2比自己小，小和为2 总体小和为 0+0+2 = 2
 *
 * @author XiaoYingGee
 * @date 2022/2/19 18:33
 */
public class ArrayMinSum {

    /**
     * 8 2 1 3
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(4);
        int[] test = new int[]{1, 3, 4, 2, 5};
        int sumResult = process(test, 0, test.length - 1);
        System.out.println(sumResult);
    }

    private static int process(int[] arr, int left, int right) {
        // 命中自己，返回0
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) / 2);
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int length = right - left + 1;
        int[] help = new int[length];
        int index = 0;
        int lIndex = left;
        int rIndex = mid + 1;
        int minSum = 0;
        while (lIndex <= mid && rIndex <= right) {
            // 左边小于右边，需要加最小和
            if (arr[lIndex] < arr[rIndex]) {
                minSum += (right - rIndex + 1) * arr[lIndex];
                help[index++] = arr[lIndex++];

            } else {
                help[index++] = arr[rIndex++];
            }
        }
        // 左边没跑完，说明左边比右边大，不加
        while (lIndex <= mid) {
            help[index++] = arr[lIndex++];
        }
        while (rIndex <= right) {
            help[index++] = arr[rIndex++];
        }

        for (int i = 0; i < length; i++) {
            arr[left + i] = help[i];
        }
        return minSum;
    }
}
