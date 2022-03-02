package com.xiaoyingge.basic.class11;

import lombok.Data;

/**
 * 给点一个特殊的二叉树，节点拥有指向父亲的parent指针
 * <p>给点树上的任意节点，都需要返回它的后置节点</p>
 * 后置节点即按中序遍历的情况下，在自己后面的节点
 *
 * @author XiaoYingGee
 * @date 2022/3/2 22:08
 */
public class SuccessorNode {

    @Data
    private static class Node {

        private int value;
        private Node left;
        private Node right;
        private Node parent;

        @Override
        public String toString() {
            return "" + this.value;
        }
    }

    public static void main(String[] args) {
    }

    private static Node tryFind(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            //如果有右孩子，找右孩子的最左节点
            return getLeftMost(node.right);
        } else { // 无右子树
            Node parent = node.parent;
            while (parent != null && parent.right == node) { // 当前节点是其父亲节点右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
