package com.xiaoyingge.sort.quick.dutchflag;

/**
 * 荷兰国旗算法，即存在重复数，将小于数放左边，等于数放中间，大于数放右边，返回等于区的边界
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/26 14:42
 */
public class DutchFlagSort {

    public static void main (String[] args) {
        int[] arr = new int[]{1, 8, 4, 76, 2, 3, 8, 8, 67, 3, 5, 6, 73, 7, 9, 8, 9, 8};
        int[] sort = new DutchFlagSort().sort(arr, 0, arr.length - 1);
        System.out.println("left is " + sort[0] + "right is" + sort[1]);
        for (int i : arr) {
            System.out.printf(i + ",");
        }
    }

    public int[] sort (int[] arr, int left, int right) {
        if (arr == null || right - left < 2) {
            return new int[]{-1, -1};
        }
        int num = arr[right];
        int position = left;
        int leftIndex = left - 1;
        int rightIndex = right;
        while (position <= rightIndex) {
            if (arr[position] < num) {
                swap(arr, position++, ++leftIndex);
            } else if (arr[position] > num) {
                swap(arr, position, --rightIndex);
            } else {
                position++;
            }
        }
        swap(arr, arr.length - 1, rightIndex);
        return new int[]{leftIndex, rightIndex};
    }

    private void swap (int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
