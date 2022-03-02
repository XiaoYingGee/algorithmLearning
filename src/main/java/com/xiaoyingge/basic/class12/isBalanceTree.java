package com.xiaoyingge.basic.class12;

import com.xiaoyingge.common.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 是否是平衡二叉树，即左右树高度不超过1
 *
 * @author XiaoYingGee
 * @date 2022/3/2 22:54
 */
public class isBalanceTree {

    public static void main(String[] args) {

    }

    public static NodeInfo isBalanceTree(Node node) {
        if (node == null) {
            return new NodeInfo(true, 0);
        }
        NodeInfo left = isBalanceTree(node.getLeft());
        NodeInfo right = isBalanceTree(node.getRight());

        //要求左右都平衡
        boolean balance = left.isBalance() && right.isBalance()
                //并且左右高度差不超过1
                && Math.abs(left.getLevel() - right.getLevel()) <= 1;
        int max = Math.max(left.getLevel(), right.getLevel()) + 1;
        return new NodeInfo(balance, max);
    }

    @Data
    @AllArgsConstructor
    private static class NodeInfo {

        /**
         * 是否平衡
         */
        private boolean balance;
        /**
         * 层高
         */
        private int level;
    }

}
