package com.xiaoyingge.sort;

import com.xiaoyingge.common.AbstractSort;
import java.util.Arrays;

/**
 * 归并排序算法，分而治之思想，将数组拆为不可拆分的组排好序再合并
 * 算法复杂度o(NlogN)
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/25 19:26
 */
public class MergeSort extends AbstractSort {

    @Override
    public void sort (int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        process(arr, left, right);
    }

    //归并的思想
    private void process (int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((start - end) >> 1);
        //从左到中间有序
        process(arr, start, mid);
        //从中点到右有序
        process(arr, mid + 1, end);
        //合并左右
        merge(arr, start, end, mid);
    }

    private void merge (int[] arr, int left, int right, int mid) {
        //创建辅助数组
        int[] tmp = new int[right - left + 1];
        int i = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        //只要没有任意指针越界,就谁小复制到新数组里
        while (leftIndex <= mid && rightIndex <= right) {
            tmp[i++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        //把另一个没写完的数组写完
        while (leftIndex <= mid) {
            tmp[i++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            tmp[i++] = arr[rightIndex++];
        }
        //写回去
        for (int i1 = 0; i1 < tmp.length; i1++) {
            //注意起点
            arr[left + i1] = tmp[i1];
        }

    }

    public static void main (String[] args) {
        AbstractSort sort = new SelectedSort();
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
