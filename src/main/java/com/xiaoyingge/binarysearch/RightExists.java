package com.xiaoyingge.binarysearch;

/**
 * 二分找一个有序数组的某个数最右侧的索引
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/6/6 11:48
 */
public class RightExists {

    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9};
        int left = 0, right = arr.length;
        int value = 5;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(index);
    }

}
