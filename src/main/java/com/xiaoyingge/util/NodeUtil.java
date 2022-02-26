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
        return createSimpleNodeList(arr);
    }

    public static Node createSimpleNodeList(int[] arr) {
        Node head = Node.simpleNode();
        Node point = head;
        int currentSize = 0;
        for (int i : arr) {
            point.setValue(i);
            point.setNext(arr.length > ++currentSize ? Node.simpleNode() : null);
            point = point.getNext();
        }
        return head;
    }

    public static Node createDoubleNodeList(int size) {
        return createDoubleNodeList(size, Integer.MAX_VALUE);
    }

    public static Node createDoubleNodeList(int size, int max) {
        int[] arr = NumUtil.createRandomArray(size, max);
        Node head = Node.doubleNode();
        Node pointer = head;
        Node pre = null;
        for (int i = 0; i < arr.length; i++) {
            pointer.setPre(pre);
            pointer.setValue(arr[i]);
            if (i != arr.length - 1) {
                Node next = Node.doubleNode();
                pointer.setNext(next);
                pre = pointer;
                pointer = next;
            }
        }
        return head;
    }

}
