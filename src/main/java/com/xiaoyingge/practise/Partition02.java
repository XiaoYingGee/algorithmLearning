package com.xiaoyingge.practise;

import com.xiaoyingge.util.NumUtil;

/**
 * 即三色问题，荷兰国旗问题
 *
 * @author XiaoYingGee
 * @date 2022/2/20 13:44
 */
public class Partition02 {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(50, 100);
        int number = 50;
        arr[13] = 50;
        arr[49] = 50;
        arr[44] = 50;
        partition(arr, number);
        System.out.println();
    }

    private static void partition(int[] arr, int number) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        for (int i = 0; i <= maxIndex; ) {

            if (arr[i] < number) {
                //小于的向前移动
                swap(arr, minIndex++, i++);

            } else if (arr[i] > number) {
                //大于的向后移动
                swap(arr, maxIndex--, i);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int areaIndex, int currentIndex) {
        if (currentIndex == areaIndex) {
            return;
        }
        int temp = arr[currentIndex];
        arr[currentIndex] = arr[areaIndex];
        arr[areaIndex] = temp;
    }

}
