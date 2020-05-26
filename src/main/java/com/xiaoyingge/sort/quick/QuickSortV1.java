package com.xiaoyingge.sort.quick;

import com.xiaoyingge.common.AbstractSort;
import java.util.Arrays;

/**
 * 运用partition算法实现
 * 复杂度o(N2)
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/26 11:30
 */
public class QuickSortV1 extends AbstractSort {

    public static void main (String[] args) {
        AbstractSort sort = new QuickSortV1();
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

    @Override
    public void sort (int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    public void partition (int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //使用partition算法 ，求出中点位置，再求两侧
        int mid = sortWithReturn(arr, left, right);
        partition(arr, left, mid - 1);
        partition(arr, mid + 1, right);
    }

    @Override
    public int sortWithReturn (int[] arr, int left, int right) {
        // 左边界
        int leftIndex = left - 1;
        //对数
        int num = arr[right];
        for (int i = left; i < right; i++) {
            //只要当前数比对数小，与小于区相邻的数交换
            if (arr[i] < num) {
                //++left即小于区的相邻数
                swap(arr, ++leftIndex, i);
            }
        }
        swap(arr, ++leftIndex, right);
        return leftIndex;
    }

}
