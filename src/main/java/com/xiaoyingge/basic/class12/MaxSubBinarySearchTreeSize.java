package com.xiaoyingge.basic.class12;

import com.xiaoyingge.common.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 根据头节点找出最大个数的搜索二叉子树
 *
 * @author XiaoYingGee
 * @date 2022/3/2 23:10
 */
public class MaxSubBinarySearchTreeSize {

    public static NodeInfo process(Node node) {
        if (node == null) {
            return null;
        }
        NodeInfo left = process(node.getLeft());
        NodeInfo right = process(node.getRight());

        int max = node.getValue();
        int min = node.getValue();
        boolean bst = true;
        if (left != null) {
            max = Math.max(max, left.getMax());
            min = Math.min(min, left.getMin());
        }
        if (right != null) {
            max = Math.max(max, right.getMax());
            min = Math.min(min, right.getMin());
        }

        if (left != null && (!left.isBst() || left.getMax() >= node.getValue())) {
            bst = false;
        }
        if (right != null && (!right.isBst() || right.getMin() <= node.getValue())) {
            bst = false;
        }
        int size = bst ? (left.getSize() + right.getSize() + 1) : Math.max(left.getSize(), right.getSize());
        return new NodeInfo(bst, max, min, size);
    }

    @Data
    @AllArgsConstructor
    private static class NodeInfo {

        private boolean bst;
        private int max;
        private int min;
        private int size;
    }
}
