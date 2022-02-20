package com.xiaoyingge.basic.class01;

import com.xiaoyingge.util.NumUtil;
import java.util.Arrays;

/**
 * 二分查找
 *
 * @author XiaoYingGee
 * @date 2022/2/20 14:48
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(100);
        Arrays.sort(arr);
        int findNum = NumUtil.random();
        boolean result = search(arr, findNum, 0, arr.length - 1);
        System.out.println(result ? "YES!!!" : "FUCK");
    }

    private static boolean search(int[] arr, int num, int left, int right) {
        if (left == right) {
            return arr[left] == num;
        }
        int mid = left + ((right - left) >> 1);
        if (arr[mid] == num) {
            return true;
        } else if (arr[mid] > num) {
            search(arr, num, left, mid - 1);
        } else {
            search(arr, num, mid + 1, right);
        }
        return false;
    }

    private static boolean search2(int[] sortedArr, int num, int left, int right) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        // left..right
        while (left < right) { // left..right 至少两个数的时候
            int mid = left + ((right - left) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return sortedArr[left] == num;
    }

}
