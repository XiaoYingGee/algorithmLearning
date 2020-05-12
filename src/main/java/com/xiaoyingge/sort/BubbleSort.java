package com.xiaoyingge.sort;

import com.xiaoyingge.common.AbstractSort;
import java.util.Arrays;

/**
 * 冒泡排序，思路是和右侧数比大小，如果左侧大，将数交换
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 20:01
 */
public final class BubbleSort extends AbstractSort {

    @Override
    public void sort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void main (String[] args) {
        AbstractSort sort = new BubbleSort();
        int[] randomArr = sort.getRandomArr(100 * 100 * 10, 1000);
        int[] copyArr = sort.copyArr(randomArr);
        sort.sort(randomArr);
        Arrays.sort(copyArr);
        for (int i = 0; i < randomArr.length; i++) {
            if (randomArr[i] != copyArr[i]) {
                System.out.println("fuck");
                break;
            }
        }
        System.out.println("over");
    }
}
