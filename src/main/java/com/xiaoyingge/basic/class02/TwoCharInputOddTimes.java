package com.xiaoyingge.basic.class02;

/**
 * 一堆数字中只有某两个数出现了奇数次，其他都是出现了偶数次
 *
 * @author XiaoYingGee
 * @date 2022/2/22 22:08
 */
public class TwoCharInputOddTimes {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // a 和 b是两种数
        // eor != 0
        // eor最右侧的1，提取出来
        // eor :     00110010110111000
        // rightOne :00000000000001000
        int rightOne = eor & (-eor); // 提取出最右的1

        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

}
