package com.xiaoyingge.basic.class10;

import com.google.common.collect.Lists;
import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import com.xiaoyingge.util.PrintUtil;
import java.util.List;
import java.util.Queue;

/**
 * 打印二叉树 使用先序 中序 后序
 *
 * @author XiaoYingGee
 * @date 2022/2/27 14:55
 */
public class PrintBinaryTree {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        Queue<Integer> queue = Lists.newLinkedList(list);
        Node root = NodeUtil.createBinaryTree(queue);
        PrintUtil.print(root);
        System.out.println("==============");
        printByPre(root);
        System.out.println();
        printByMid(root);
        System.out.println();
        printByPos(root);
        System.out.println();
    }

    private static void printByPos(Node root) {
        if (root == null) {
            return;
        }
        printByPos(root.getLeft());
        printByPos(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    private static void printByMid(Node root) {
        if (root == null) {
            return;
        }
        printByMid(root.getLeft());
        System.out.print(root.getValue() + " ");
        printByMid(root.getRight());
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    private static void printByPre(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        printByPre(root.getLeft());
        printByPre(root.getRight());
    }
}
