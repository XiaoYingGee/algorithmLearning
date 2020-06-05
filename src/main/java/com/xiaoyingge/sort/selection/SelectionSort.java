package com.xiaoyingge.sort.selection;

import com.xiaoyingge.common.AbstractSort;
import java.util.Arrays;

/**
 * 选择排序实现，即从全局找到最小的放到最前面
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 19:22
 */
public final class SelectionSort extends AbstractSort {

    @Override
    public void sort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果新索引上的数小于当前最小索引上的数，更新索引
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            //交换数据
            swap(arr, i, minIndex);
        }
    }

    public static void main (String[] args) {
        AbstractSort sort = new SelectionSort();
        int[] randomArr = sort.getRandomArr(100 * 100 * 10, 1000);
        randomArr = new int[]{6, 5, 4, 3, 2, 1};
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
