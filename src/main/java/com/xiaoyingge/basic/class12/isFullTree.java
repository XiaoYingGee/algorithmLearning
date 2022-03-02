package com.xiaoyingge.basic.class12;

import com.xiaoyingge.common.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 判断一个树是否是满二叉树
 *
 * @author XiaoYingGee
 * @date 2022/3/2 23:00
 */
public class isFullTree {

    public static boolean isFullTree(Node node) {
        if (node == null) {
            return true;
        }
        return process(node).isFull();
    }

    public static NodeInfo process(Node node) {
        if (node == null) {
            return new NodeInfo(true, 0);
        }
        NodeInfo left = process(node.getLeft());
        NodeInfo right = process(node.getRight());

        int level = Math.max(left.getLevel(), right.getLevel()) + 1;
        boolean full = left.isFull() && right.isFull() && left.getLevel() == right.getLevel();
        return new NodeInfo(full, level);
    }

    @Data
    @AllArgsConstructor
    private static class NodeInfo {

        private boolean full;

        private int level;
    }

}
