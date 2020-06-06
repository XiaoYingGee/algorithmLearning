package com.xiaoyingge.binarysearch;

import java.util.Arrays;
import java.util.Random;

/**
 * 可重复的数组，二分查找某个数的最左铡的索引
 * 如 112233，查找2的左侧索引，得到2
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
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //核心思想就是找到了值继续向左边逼近
            if (arr[mid] >= randomIndex) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("index " + index);
    }

    private static int[] getArr () {
        Random random = new Random();
        int[] result = generateRandomArray(random.nextInt(10000), random.nextInt(10000));
        result = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4};
        randomIndex = result[random.nextInt(result.length)];
        randomIndex = 3;
        System.out.println("random answer is " + randomIndex);
        Arrays.sort(result);
        return result;
    }

    // for test
    public static int[] generateRandomArray (int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
