package com.xiaoyingge.common;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 20:02
 */
public abstract class AbstractSort implements Sort {

    protected void swap (int[] arr, int i, int minIndex) {
        //数据一样没必要交换
        if (i == minIndex) {
            return;
        }
        //数据换位
        arr[i] = arr[i] ^ arr[minIndex];
        arr[minIndex] = arr[i] ^ arr[minIndex];
        arr[i] = arr[i] ^ arr[minIndex];
    }

    public int[] getRandomArr (int bounds, int numRange) {
        Random random = new Random();
        int numCount = random.nextInt(bounds);
        int[] result = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            int num = random.nextInt(numRange) - random.nextInt(numRange);
            result[i] = num;
        }
        return result;
    }

    public int[] copyArr (int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

}
