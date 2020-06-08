package com.xiaoyingge.sort.heap;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/5 19:05
 */
public class BigRoot {

    private int[] heap;

    private final int limit;

    private int heapSize;

    public BigRoot (int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    //左节点找根就是/2 可节点找根 就是/2-1
    public static void main (String[] args) {
        int[] arr = {5, 32, 6, 6, 7, 1, 3, 2, 2, 5, 6, 7};
        BigRoot bigRoot = new BigRoot(12);
        for (int i : arr) {
            bigRoot.push(i);
        }
        for (int i : bigRoot.heap) {
            System.out.print(i + "|");
        }
        System.out.println();
        for (int i = 0; i < 2; i++) {
            System.out.println(bigRoot.pop());
        }
        System.out.println();
        for (int i : bigRoot.heap) {
            System.out.print(i + "|");
        }
        System.out.println();
    }

    /**
     * 保存每次新增一个数后，会调整大根堆的结构,保证不管怎么输入一个数，内部都是大根堆结构
     *
     * @param value
     */
    public void push (int value) {
        if (heapSize == limit) {
            System.out.println("满啦");
            return;
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    /**
     * 弹出最大值，即根节点，其他节点补充为大根堆
     */
    public int pop () {
        int answer = heap[0];
        //将最大值放到队尾
        swap(heap, 0, --heapSize);
        //重排
        heapify(heap, 0, heapSize);
        return answer;
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

    private void heapInsert (int[] heap, int currentLength) {
        while (heap[currentLength] > heap[(currentLength - 1) / 2]) {
            swap(heap, currentLength, (currentLength - 1) / 2);
            currentLength = (currentLength - 1) / 2;
        }
    }

    private void swap (int[] heap, int currentLength, int i) {
        if (currentLength == i) {
            return;
        }
        heap[currentLength] = heap[currentLength] ^ heap[i];
        heap[i] = heap[currentLength] ^ heap[i];
        heap[currentLength] = heap[currentLength] ^ heap[i];

    }

}
