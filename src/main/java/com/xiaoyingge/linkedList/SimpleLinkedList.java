package com.xiaoyingge.linkedList;

import java.util.Random;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/6 13:49
 */
public class SimpleLinkedList {

    public Node getRandomLinkedList (int size, int maxValue) {
        Random random = new Random();
        Node head = new Node(random.nextInt(maxValue));
        Node pointer = head;
        for (int i = 1; i < size; i++) {
            Node nextNode = new Node(random.nextInt(maxValue));
            pointer.next = nextNode;
            pointer = nextNode;
        }
        return head;
    }

    public static class Node {

        public Node next;

        public int value;

        public Node (int value) {
            this.value = value;
        }
    }
}
