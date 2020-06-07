package com.xiaoyingge.linkedList;

import com.xiaoyingge.linkedList.DoubleLinkedList.Node;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/7 18:40
 */
public class BuildStackByDoubleLinkedList {

    public static void main (String[] args) {
        DoubleLinkedList randomLinkedList = new DoubleLinkedList().getRandomLinkedList(5, 10);
        print(randomLinkedList.head);
        System.out.println(randomLinkedList.popTail());
        System.out.println(randomLinkedList.popTail());
        System.out.println(randomLinkedList.popTail());
        System.out.println(randomLinkedList.popTail());
        System.out.println(randomLinkedList.popTail());
        System.out.println(randomLinkedList.popTail());

        randomLinkedList.pushHead(new Node(12));
        randomLinkedList.pushHead(new Node(13));
        randomLinkedList.pushHead(new Node(14));
        randomLinkedList.pushHead(new Node(15));
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        randomLinkedList.pushHead(new Node(16));
        randomLinkedList.pushHead(new Node(17));
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
    }

    private static void print (Node head) {
        while (head != null) {
            System.out.print(head.value + "|");
            head = head.next;
        }
        System.out.println();
    }
}
