package com.xiaoyingge.linkedList;

import java.util.Random;

/**
 * 一个双向链表
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/6/7 17:37
 */
public class DoubleLinkedList {

    public Node head;

    public Node tail;

    public int size = 0;

    public void pushHead (Node node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void pushTail (Node node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public int popHead () {
        if (size == 0) {
            System.out.println("没数了。pop个鬼啊");
            return -1;
        } else if (size == 1) {
            int result = head.value;
            head = null;
            tail = null;
            size--;
            return result;
        } else {
            Node pop = head;
            head = head.next;
            head.prev = null;
            size--;
            return pop.value;
        }
    }

    public int popTail () {
        if (size == 0) {
            System.out.println("没数了。pop个鬼啊");
            return -1;
        } else if (size == 1) {
            int result = tail.value;
            head = null;
            tail = null;
            size--;
            return result;
        } else {
            Node pop = tail;
            tail = tail.prev;
            tail.next = null;
            size--;
            return pop.value;
        }
    }

    public DoubleLinkedList getRandomLinkedList (int size, int maxValue) {
        Random random = new Random();
        Node randomHead = new Node(random.nextInt(maxValue));
        head = randomHead;
        tail = randomHead;
        for (int i = 1; i < size; i++) {
            Node nextNode = new Node(random.nextInt(maxValue));
            randomHead.next = nextNode;
            nextNode.prev = randomHead;
            randomHead = nextNode;
            tail = nextNode;
        }
        this.size = size;
        return this;
    }

    public static class Node {

        public Node prev;

        public Node next;

        public int value;

        public Node (int value) {
            this.value = value;
        }
    }

}
