package com.xiaoyingge.binarysearch;

import java.util.Random;

/**
 * 查找有序可重复数列中最左侧的索引号
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 21:07
 */
public class LeftExists {

    static int randomIndex = 0;

    public static void main (String[] args) {
        int[] arr = getArr();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == randomIndex) {
                System.out.println("found");
                System.out.println("left " + left + " right " + right);
                return;
            } else if (arr[mid] > randomIndex) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private static int[] getArr () {
        Random random = new Random();
        int range = random.nextInt(100 * 100 * 100);
        System.out.println("range is " + range);
        randomIndex = random.nextInt(range);
        System.out.println("randomIndex is " + randomIndex);
        int[] result = new int[range];
        for (int i = 0; i < range; i++) {
            result[i] = i;
        }
        return result;
    }
}
