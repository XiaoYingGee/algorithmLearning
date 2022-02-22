package com.xiaoyingge.basic.class02;

import com.xiaoyingge.util.NumUtil;

/**
 * 异或的数字交换
 *
 * @author XiaoYingGee
 * @date 2022/2/22 22:03
 */
public class Swap {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(2);
        NumUtil.print(arr);
        NumUtil.swap(arr, 0, 1);
        NumUtil.print(arr);
    }
}
