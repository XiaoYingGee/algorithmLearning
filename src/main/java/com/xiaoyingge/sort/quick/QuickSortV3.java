package com.xiaoyingge.sort.quick;

import com.xiaoyingge.common.AbstractSort;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/5/26 16:51
 */
public class QuickSortV3 extends AbstractSort {

    private static final Random RANDOM = new Random();

    public static void main (String[] args) {
        AbstractSort sort = new QuickSortV3();
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
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort (int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] partition = partition(arr, left, right);
        quickSort(arr, left, partition[0] - 1);
        quickSort(arr, partition[1] + 1, right);
    }

    private int[] partition (int[] arr, int left, int right) {
        if (right > left + 1) {
            int randomIndex = RANDOM.nextInt(right - left) + left;
            swap(arr, randomIndex, right);
        }
        int num = arr[right];
        int position = left;
        int leftIndex = left - 1;
        int rightIndex = right;
        while (position < rightIndex) {
            if (arr[position] < num) {
                swap(arr, position++, ++leftIndex);
            } else if (arr[position] > num) {
                swap(arr, position, --rightIndex);
            } else {
                position++;
            }
        }
        swap(arr, right, rightIndex);
        return new int[]{leftIndex + 1, rightIndex - 1};
    }
}
