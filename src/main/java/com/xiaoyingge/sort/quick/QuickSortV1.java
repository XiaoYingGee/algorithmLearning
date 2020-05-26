package com.xiaoyingge.sort.quick;

/**
 * 运用partition算法实现
 * 复杂度o(N2)
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/26 11:30
 */
public class QuickSortV1 {

    public static void main (String[] args) {
        int[] arr = new int[]{1, 4, 76, 2, 3, 673, 5, 6, 73, 7, 9, 9, 8};
        new QuickSortV1().partition(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.printf(i + ",");
        }
    }

    public void partition (int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //使用partition算法 ，求出中点位置，再求两侧
        int mid = sort(arr, left, right);
        partition(arr, left, mid - 1);
        partition(arr, mid + 1, right);
    }

    private int sort (int[] arr, int left, int right) {
        // 左边界
        int leftIndex = left - 1;
        //对数
        int num = arr[right];
        for (int i = left; i < right; i++) {
            //只要当前数比对数小，与小于区相邻的数交换
            if (arr[i] < num) {
                //++left即小于区的相邻数
                swap(arr, ++leftIndex, i);
            }
        }
        swap(arr, ++leftIndex, right);
        return leftIndex;
    }

    private void swap (int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
