package com.xiaoyingge.sort.insertion;

import com.xiaoyingge.common.AbstractSort;
import java.util.Arrays;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 20:21
 */
public class InsertionSort extends AbstractSort {

    @Override
    public void sort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, i, j);
            }
        }
    }

    public static void main (String[] args) {
        AbstractSort sort = new InsertionSort();
        int[] randomArr = sort.getRandomArr(100 * 100 * 10, 1000);
        int[] copyArr = sort.copyArr(randomArr);
        sort.sort(randomArr);
        Arrays.sort(copyArr);
        for (int i = 0; i < randomArr.length; i++) {
            if (randomArr[i] != copyArr[i]) {
                System.out.println("fuck" + randomArr[i] + "," + copyArr[i]);
                break;
            }
        }
        System.out.println("over");
    }
}
