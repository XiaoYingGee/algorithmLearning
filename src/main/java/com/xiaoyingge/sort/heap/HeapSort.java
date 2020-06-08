package com.xiaoyingge.sort.heap;

import com.xiaoyingge.common.AbstractSort;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/5 23:53
 */
public class HeapSort extends AbstractSort {

    //左节点找根就是/2 可节点找根 就是/2-1
    public static void main (String[] args) {
        int[] arr = {5, 4, 6, 6, 7, 1, 3, 2, 2, 5, 6, 32};
        new HeapSort().sort(arr);
        for (int i : arr) {
            System.out.print(i + "|");
        }
    }

    @Override
    public void sort (int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            //倒序组织大根堆，时间复杂度最低
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        //将最大的数扔到屁股上
        swap(arr, 0, --heapSize);
        // O(N)
        while (heapSize > 0) {
            // O(logN)
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 让数组从0-R范围组织成大根堆
     *
     * @param heap
     * @param index
     * @param heapSize
     */
    private void heapify (int[] heap, int index, int heapSize) {
        //找到左节点索引
        int leftIndex = index * 2 + 1;
        while (leftIndex < heapSize) {
            //右节点（不一定存在）
            int rightIndex = leftIndex + 1;
            //判断左右节点谁更大，返回对应的索引（右节点不存在的情况下以左节点为准）
            int largerIndex = rightIndex < heapSize && heap[rightIndex] > heap[leftIndex] ? rightIndex : leftIndex;
            //判断孩子中较大的值和根节点相比，哪个大
            int compareWithRoot = heap[index] > heap[largerIndex] ? index : largerIndex;
            //如果根节点大于自己的孩子，就停止执行
            if (compareWithRoot == index) {
                break;
            }
            //将较大的值上提
            swap(heap, index, largerIndex);
            //走到这里，说明根节点是比较小的，因此交换后，largerIndex里就是原来的根节点
            index = largerIndex;
            //计算新的左节点，重复
            leftIndex = index * 2 + 1;
        }

    }
}
