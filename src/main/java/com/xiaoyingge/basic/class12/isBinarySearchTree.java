package com.xiaoyingge.basic.class12;

import com.xiaoyingge.common.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 是否是搜索二叉树，即任意子树均满足  中间比左边大 比右边小
 *
 * @author XiaoYingGee
 * @date 2022/3/2 22:37
 */
public class isBinarySearchTree {

    public static void main(String[] args) {

    }

    public static NodeInfo isBinarySearchTree(Node node) {
        if (node == null) {
            return null;
        }
        NodeInfo left = isBinarySearchTree(node.getLeft());
        NodeInfo right = isBinarySearchTree(node.getRight());

        int max = node.getValue();
        int min = node.getValue();
        if (left != null) {
            max = Math.max(left.getMax(), max);
            min = Math.min(left.getMin(), min);
        }
        if (right != null) {
            max = Math.max(right.getMax(), max);
            min = Math.min(right.getMin(), min);
        }

        boolean isBst = true;
        if (left != null && !left.isBst()) {
            isBst = false;
        }
        if (right != null && !right.isBst()) {
            isBst = false;
        }
        if (left != null && left.getMax() >= node.getValue()) {
            isBst = false;
        }
        if (right != null && right.getMin() <= node.getValue()) {
            isBst = false;
        }
        return new NodeInfo(isBst, max, min);

    }

    @Data
    @AllArgsConstructor
    private static class NodeInfo {

        private boolean bst;
        private int max;
        private int min;
    }

}
