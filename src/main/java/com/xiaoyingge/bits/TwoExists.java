package com.xiaoyingge.bits;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/6 11:56
 */
public class TwoExists {

    public static void main (String[] args) {
        int[] arr = {3, 3, 4, 5, 4, 4, 5, 6, 6, 6, 6, 3};
        //全部异或，计算中间值
        int temp = 0;
        for (int i : arr) {
            temp ^= i;
        }
        //提取出最右的位，使用的是取非加1法
        //假设原来是 0100010101100
        //取非之后   1011101010011，取非后与之前的每一位都不相同，直接相与的结果是0
        //取非加一   1011101010100  因为加一产生或者不产生进位
        //与结果     0000000000100  最右侧的1被取出
        int rightOne = temp & (~temp + 1);
        //这个就是用来标示rightOne上为1的数
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (temp ^ onlyOne));
    }

}
