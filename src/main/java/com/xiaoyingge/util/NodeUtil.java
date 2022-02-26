package com.xiaoyingge.util;

import com.xiaoyingge.common.Node;

/**
 * @author XiaoYingGee
 * @date 2022/2/22 22:16
 */
public class NodeUtil {

    public static Node createSimpleNodeList(int size) {
        return createSimpleNodeList(size, Integer.MAX_VALUE);
    }

    public static Node createSimpleNodeList(int size, int max) {
        int[] arr = NumUtil.createRandomArray(size, max);
        Node head = new Node();
        Node point = head;
        int currentSize = 0;
        for (int i : arr) {
            point.setValue(i);
            point.setNext(size > ++currentSize ? new Node() : null);
            point = point.getNext();
        }
        return head;
    }

    public static Node createDoubleNodeList(int size) {
        return createDoubleNodeList(size, Integer.MAX_VALUE);
    }

    public static Node createDoubleNodeList(int size, int max) {
        int[] arr = NumUtil.createRandomArray(size, max);
        Node head = new Node();
        Node pre = null;
        for (int i = 0; i < arr.length; i++) {
            head.setPre(pre);
            head.setValue(arr[i]);
            if (i != arr.length - 1) {
                Node next = new Node();
                head.setNext(next);
                pre = head;
                head = next;
            }
        }
        return head;
    }

}
