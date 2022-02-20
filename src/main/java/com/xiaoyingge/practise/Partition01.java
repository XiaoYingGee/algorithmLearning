package com.xiaoyingge.practise;

import com.xiaoyingge.util.NumUtil;

/**
 * 针对某个数据，对它进行排位，让左边的数都小于自己，右边的数都大于自己
 *
 * @author XiaoYingGee
 * @date 2022/2/20 13:02
 */
public class Partition01 {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(30, 200);
        int number = 100;
        partition(arr, number);
        System.out.println();
    }

    private static void partition(int[] arr, int number) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < number) {
                NumUtil.swap(arr, minIndex++, i);
            }
        }
    }

}
