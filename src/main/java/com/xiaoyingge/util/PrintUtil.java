package com.xiaoyingge.util;

import com.xiaoyingge.common.Node;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author XiaoYingGee
 * @date 2022/2/22 22:21
 */
public class PrintUtil {

    public static void print(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.toList()));
    }

    public static void print(Node node) {
        if (node.getType() == 1) {
            printSimpleNode(node);
        } else if (node.getType() == 2) {
            printDoubleNode(node);
        } else {
            printTree(node);
        }
    }

    private static void printTree(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        //用来记录最后一个右节点
        Node currentRight = node;
        Node nextRight = null;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                System.out.print("null     ");
                continue;
            }
            System.out.print(current.getValue() + "    ");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
                nextRight = current.getLeft();
            } else {
                queue.add(null);
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
                nextRight = current.getRight();
            } else {
                queue.add(null);
            }

            if (current == currentRight) {
                System.out.println();
                currentRight = nextRight;
            }
        }
        System.out.println();
    }

    private static void printSimpleNode(Node node) {
        Node pointer = node;
        while (pointer != null) {
            System.out.print(pointer.getValue() + " -> ");
            pointer = pointer.getNext();
        }
        System.out.println();
    }

    public static void printDoubleNode(Node node) {
        Node pointer = node;
        boolean notEnd = true;
        boolean isDoubleNode = node.isDoubleNode();
        while (pointer != null) {
            System.out.print(pointer.getValue() + (notEnd ? " -> " : " <- "));
            if (pointer.getNext() == null && isDoubleNode && notEnd) {
                notEnd = false;
                System.out.println();
                System.out.print(pointer.getValue() + " <- ");
            }
            pointer = notEnd ? pointer.getNext() : pointer.getPre();

        }
        System.out.println();
    }
}
