package com.xiaoyingge.linkedList;

import com.xiaoyingge.linkedList.DoubleLinkedList.Node;

/**
 * 通过双向链表构建队列
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/6/7 17:36
 */
public class BuildQueueByDoubleLinkedList {

    public static void main (String[] args) {
        DoubleLinkedList randomLinkedList = new DoubleLinkedList().getRandomLinkedList(5, 10);
        print(randomLinkedList.head);
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());

        randomLinkedList.pushTail(new Node(12));
        randomLinkedList.pushTail(new Node(13));
        randomLinkedList.pushTail(new Node(14));
        randomLinkedList.pushTail(new Node(15));
        System.out.println(randomLinkedList.popHead());
        System.out.println(randomLinkedList.popHead());
        randomLinkedList.pushTail(new Node(16));
        randomLinkedList.pushTail(new Node(17));
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
