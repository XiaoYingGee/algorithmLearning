package com.xiaoyingge.basic.class02;

import com.xiaoyingge.util.NumUtil;
import com.xiaoyingge.util.PrintUtil;

/**
 * 异或的数字交换
 *
 * @author XiaoYingGee
 * @date 2022/2/22 22:03
 */
public class Swap {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(2);
        PrintUtil.print(arr);
        NumUtil.swap(arr, 0, 1);
        PrintUtil.print(arr);
    }
}
