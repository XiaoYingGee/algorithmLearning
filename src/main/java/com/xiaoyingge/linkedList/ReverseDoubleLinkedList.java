package com.xiaoyingge.linkedList;

import java.util.Random;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/6 12:06
 */
public class ReverseDoubleLinkedList {

    private static class Node {

        public Node prev;

        public Node next;

        public int value;

        public Node (int value) {
            this.value = value;
        }

    }

    public static void main (String[] args) {
        Node head = buildRandomLinkedList();
        Node pointer = head;
        while (true) {
            System.out.print(pointer.value + ",");
            if (pointer.next == null) {
                break;
            }
            pointer = pointer.next;

        }
        System.out.println();
        while (true) {
            System.out.print(pointer.value + ",");
            if (pointer.prev == null) {
                break;
            }
            pointer = pointer.prev;
        }
        Node prev = null;
        while (true) {
            //修改前置
            pointer.prev = pointer.next;
            //修改后置
            pointer.next = prev;
            //前置指针指向当前节点
            prev = pointer;
            //节点向后移动
            pointer = pointer.prev;

            if (pointer == null) {
                break;
            }
        }
        System.out.println();
        while (head != null) {
            System.out.print(head.value + ",");
            head = head.prev;
        }

    }

    private static Node buildRandomLinkedList () {
        Random random = new Random();
        int nodeSize = 5;
        Node prev = null;
        Node head = null;
        for (int i = 0; i < nodeSize; i++) {
            Node node = new Node(random.nextInt(1000));
            if (i == 0) {
                head = node;
            }
            node.prev = prev;
            prev = node;
            if (node.prev != null) {
                node.prev.next = node;
            }
        }
        return head;
    }

}
