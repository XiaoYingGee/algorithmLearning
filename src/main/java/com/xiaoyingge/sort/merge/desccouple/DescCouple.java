package com.xiaoyingge.sort.merge.desccouple;

/**
 * 降序对问题 即数与右边的任意小于自己的数组成一对降序对
 * 3,7,2,5 中 降序对有  3-2  7-2  7-5
 * 本质上还是一个排序算法，
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/25 20:25
 */
public class DescCouple {

    public static void main (String[] args) {
        int descCouple = new DescCouple().getDescCouple(new int[]{3, 1, 7, 0, 2});
        System.out.println(descCouple);
    }

    public int getDescCouple (int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return process(arr, left, right);
    }

    private int process (int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) +
                process(arr, mid + 1, right) +
                merge(arr, left, right, mid);

    }

    private int merge (int[] arr, int left, int right, int mid) {
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int result = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            //核心都是在计算这里，在左侧有数大于右侧时，则左侧所有数均大于右侧，形成逆序对
            result += (arr[leftIndex] > arr[rightIndex] ? mid - leftIndex + 1 : 0);
            tmp[index++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            tmp[index++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            tmp[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
        return result;
    }

}
