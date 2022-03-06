package com.xiaoyingge.basic.class13;

import com.xiaoyingge.common.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回最大的搜索二叉树头节点
 *
 * @author XiaoYingGee
 * @date 2022/3/6 21:26
 */
public class MaxSubBSTHead {

    @Data
    @AllArgsConstructor
    public static class NodeInfo {

        private Node node;
        private int size;
        private int max;
        private int min;
    }

    public static NodeInfo process(Node head) {
        if (head == null) {
            return null;
        }
        NodeInfo left = process(head.getLeft());
        NodeInfo right = process(head.getRight());

        Node node = null;
        int size = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        if (left != null) {
            max = Math.max(max, left.getMax());
            min = Math.min(min, left.getMin());
        }

        if (right != null) {
            max = Math.max(max, right.getMax());
            min = Math.min(min, right.getMin());
        }

        if (left != null && left.getNode() != null && left.getMax() < node.getValue()
                && right != null && right.getNode() != null && right.getMin() > node.getValue()) {
            node = head;
        }

        size = node == head ? (left.getSize() + right.getSize() + 1) : Math.max(left.getSize(), right.getSize());
        return new NodeInfo(node, size, max, min);
    }
}
