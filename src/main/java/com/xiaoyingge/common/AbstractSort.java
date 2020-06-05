package com.xiaoyingge.common;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 20:02
 */
public abstract class AbstractSort implements Sort {

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

    @Override
    public void sort (int[] arr) {

    }

    @Override
    public int sortWithReturn (int[] arr, int left, int right) {
        return 0;
    }

    protected void swap (int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
//        System.out.println("swap " + arr[i] + "," + arr[j]);
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
