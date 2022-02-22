package com.xiaoyingge.basic.class02;

/**
 * 一堆数字中只有某一个数出现了奇数次，其他都是出现了偶数次
 *
 * @author XiaoYingGee
 * @date 2022/2/22 22:05
 */
public class OneCharInputOddTimes {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5};
        int result = 0;
        for (int i : arr) {
            result ^= arr[i];
        }
        System.out.println(result);
    }

}
