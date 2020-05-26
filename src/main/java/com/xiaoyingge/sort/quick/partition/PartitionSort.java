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
        new PartitionSort().partition(arr);
        for (int i : arr) {
            System.out.printf(i + ",");
        }
    }

    public void partition (int[] arr) {
        // 左边界
        int left = -1;
        //对数
        int num = arr[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            //只要当前数比对数小，与小于区相邻的数交换
            if (arr[i] < num) {
                //++left即小于区的相邻数
                swap(arr, ++left, i);
            }
        }
        swap(arr, ++left, arr.length - 1);
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
