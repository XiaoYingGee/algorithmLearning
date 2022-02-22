package com.xiaoyingge.basic.class01;

import com.xiaoyingge.util.NumUtil;
import java.util.Arrays;

/**
 * 二分最右侧
 *
 * @author XiaoYingGee
 * @date 2022/2/22 21:37
 */
public class BinarySearchNearRight {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(30, 10);
        Arrays.sort(arr);
        int findNum = NumUtil.random(10);
        int index = search(arr, findNum, 0, arr.length - 1);
        NumUtil.print(arr);
        System.out.println(findNum + "," + index);
    }

    private static int search(int[] arr, int findNum, int left, int right) {
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= findNum) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
