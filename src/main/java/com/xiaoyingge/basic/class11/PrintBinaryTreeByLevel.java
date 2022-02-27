package com.xiaoyingge.basic.class11;

import com.google.common.collect.Lists;
import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import com.xiaoyingge.util.PrintUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 按层打印二叉树，即宽度优先遍历
 *
 * @author XiaoYingGee
 * @date 2022/2/27 15:58
 */
public class PrintBinaryTreeByLevel {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(3, null, 2, 1, null, null, null);
        Queue<Integer> queue = Lists.newLinkedList(list);
        Node root = NodeUtil.createBinaryTree(queue);
        PrintUtil.print(root);
        System.out.println("==================");

        printByLevel(root);
    }

    private static void printByLevel(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            if (pollNode == null) {
                return;
            }
            System.out.print(pollNode);
            if (pollNode.getLeft() != null) {
                queue.add(pollNode.getLeft());
            }
            if (pollNode.getRight() != null) {
                queue.add(pollNode.getRight());
            }
        }
        System.out.println();
    }

}
