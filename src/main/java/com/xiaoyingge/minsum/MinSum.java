package com.xiaoyingge.minsum;

/**
 * 求小和，即将所有左侧比自己小的数的和加起来就是小和
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/25 20:02
 */
public class MinSum {

    public int getMinSum (int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return process(arr, left, right);
    }

    private int process (int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) >> 1;
        return process(arr, left, mid) +
                process(arr, mid + 1, right) +
                merge(arr, left, right, mid);
    }

    private int merge (int[] arr, int left, int right, int mid) {
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int leftIndex = left;
        int rightIndex = right;
        int result = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            //因为此时左右两侧的数据都已经排序完成，因此只要左指钍指向的数小于右指针的指向，则右指针后面的数都比左边的数大
            result += arr[leftIndex] < arr[rightIndex] ? (right - rightIndex + 1) * arr[leftIndex] : 0;
            tmp[index++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            tmp[index++] = arr[leftIndex++];
        }
        while (rightIndex <= mid) {
            tmp[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
        return result;
    }

}
