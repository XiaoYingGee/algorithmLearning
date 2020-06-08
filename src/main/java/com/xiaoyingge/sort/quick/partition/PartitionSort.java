package com.xiaoyingge.sort.quick.partition;

/**
 * 对于一个给定的数K，让数组内左铡数全小于等于K，右侧数全大于K
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/26 11:31
 */
public class PartitionSort {

    public static void main (String[] args) {
        int[] arr = new int[]{1, 4, 76, 2, 3, 673, 5, 6, 73, 7, 9, 9, 8};
        new PartitionSort().partition(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.printf(i + ",");
        }
    }

    public int partition (int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        // 左边界
        int leftIndex = left - 1;
        //对数
        int num = arr[right];
        for (int i = left; i < right; i++) {
            //只要当前数小于等于对数，与小于区相邻的数交换
            if (arr[i] <= num) {
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
