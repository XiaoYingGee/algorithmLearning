package com.xiaoyingge.basic.class01;

import com.xiaoyingge.util.NumUtil;
import java.util.Arrays;

/**
 * 查找最左边的值
 *
 * @author XiaoYingGee
 * @date 2022/2/22 21:31
 */
public class BinarySearchNearLeft {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(30, 10);
        Arrays.sort(arr);
        int findNum = NumUtil.random(10);
        int index = search(arr, findNum, 0, arr.length - 1);
        NumUtil.print(arr);
        System.out.println(findNum + "," + index);
    }

    private static int search(int[] arr, int num, int left, int right) {
        int index = -1;
        // left..right至少一个数的时候
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
