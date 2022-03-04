package com.xiaoyingge.basic.class13;

import com.xiaoyingge.common.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 找二叉树的公共祖先，即对于一个二叉树，给定两个不同的点a,b 找到最下面的他俩的共同祖先节点
 *
 * @author XiaoYingGee
 * @date 2022/3/4 0:42
 */
public class LowestAncestor {

    @Data
    @AllArgsConstructor
    private static class NodeInfo {

        private Node commonParent;
        private Node aPoint;
        private Node bPoint;
    }

    public static NodeInfo process(Node node, Node a, Node b) {
        if (node == null) {
            return new NodeInfo(null, null, null);
        }
        NodeInfo left = process(node.getLeft(), a, b);
        NodeInfo right = process(node.getRight(), a, b);

        Node commonParent = null;
        Node aPoint = null;
        Node bPoint = null;

        if (node == a || left.getAPoint() == a || right.getAPoint() == a) {
            aPoint = a;
        }
        if (node == b || left.getBPoint() == b || right.getBPoint() == b) {
            bPoint = b;
        }

        if (commonParent == null && aPoint != null && bPoint != null) {
            commonParent = node;
        }
        return new NodeInfo(commonParent, aPoint, bPoint);
    }
}
