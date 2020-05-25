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
        //i的递增让j的循环范围不断减小
        for (int i = 0; i < arr.length; i++) {
            //这里之所以减1是因为比较的是J和J+1，当走到size-2的时候，J+1=size-1,到达数组边界
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
