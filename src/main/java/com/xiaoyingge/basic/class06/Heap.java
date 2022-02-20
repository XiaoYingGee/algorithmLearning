package com.xiaoyingge.basic.class06;

import com.xiaoyingge.util.NumUtil;
import lombok.Data;

/**
 * 数组表示大根堆或者小根堆
 *
 * @author XiaoYingGee
 * @date 2022/2/20 20:16
 */
@Data
public class Heap {

    private int limit;
    private int size;
    private int[] heap;

    private Heap(int limit) {
        this.limit = limit;
        heap = new int[limit];
    }

    /**
     * 输入一个数，输入完之后还组成大根堆
     *
     * @param num
     */
    private void push(int num) {
        if (this.size == this.limit) {
            throw new RuntimeException("FUCK ! OUT OF RANGE!");
        }
        this.heap[size] = num;
        int index = size++;
        while (this.heap[index] > this.heap[(index - 1) / 2]) {
            NumUtil.swap(this.heap, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        for (int i = 0; i < 10; i++) {
            heap.push(NumUtil.random(100));
        }
        NumUtil.print(heap.getHeap());
        for (int i = 0; i < 10; i++) {
            System.out.println("=====================");
            System.out.println("pop=" + heap.pop());
            System.out.println("=====================");
            NumUtil.print(heap.getHeap());
        }
    }

    private int pop() {
        int result = this.heap[0];
        NumUtil.swap(this.heap, 0, --size);
        heapify(0, this.size);
        return result;
    }

    private void heapify(int index, int size) {
        //这是左节点，有可能有右，有可能没有
        int left = 2 * index + 1;
        while (left < size) {
            //算出子节点较大的
            int maxSubIndex = left + 1 < size && heap[left + 1] > heap[left] ? left + 1 : left;
            maxSubIndex = heap[maxSubIndex] > heap[index] ? maxSubIndex : index;
            if (index == maxSubIndex) {
                break;
            }
            NumUtil.swap(heap, index, maxSubIndex);
            index = maxSubIndex;
            left = 2 * index + 1;
        }

    }

}
