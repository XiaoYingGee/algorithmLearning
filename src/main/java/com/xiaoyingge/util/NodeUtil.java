package com.xiaoyingge.util;

import com.xiaoyingge.common.Node;
import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 使用先序数组构建数结构
     *
     * @param queue
     */
    public static Node createBinaryTree(Queue<Integer> queue) {
        return createBinaryTree(queue, 1);
    }

    public static Node createBinaryTree(Queue<Integer> queue, int type) {
        if (type == 1) {
            return buildByLevel(queue);
        } else if (type == 2) {
            return buildPreTree(queue);
        }
        return buildByLevel(queue);
    }

    private static Node buildPreTree(Queue<Integer> queue) {
        Integer value = queue.poll();
        if (value == null) {
            return null;
        }
        Node head = Node.binaryNode();
        head.setValue(value);
        head.setLeft(buildPreTree(queue));
        head.setRight(buildPreTree(queue));
        return head;
    }

    private static Node buildByLevel(Queue<Integer> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        Node head = buildTreeNode(queue.poll());
        Queue<Node> linkedList = new LinkedList<Node>();
        if (head != null) {
            linkedList.add(head);
        }
        Node node = null;
        while (!linkedList.isEmpty()) {
            node = linkedList.poll();
            node.setLeft(buildTreeNode(queue.poll()));
            node.setRight(buildTreeNode(queue.poll()));
            if (node.getLeft() != null) {
                linkedList.add(node.getLeft());
            }
            if (node.getRight() != null) {
                linkedList.add(node.getRight());
            }
        }
        return head;
    }

    private static Node buildTreeNode(Integer poll) {
        if (poll == null) {
            return null;
        }
        Node node = Node.binaryNode();
        node.setValue(poll);
        return node;
    }
}
