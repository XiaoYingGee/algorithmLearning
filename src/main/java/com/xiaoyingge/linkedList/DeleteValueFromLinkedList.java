package com.xiaoyingge.linkedList;

import com.xiaoyingge.linkedList.SimpleLinkedList.Node;

/**
 * 给定一个链表，删除指定的数
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/6/6 13:49
 */
public class DeleteValueFromLinkedList {

    public static void main (String[] args) {
        Node head = new SimpleLinkedList().getRandomLinkedList(20, 1);
        printLinkedList(head);
        Node newHead = deleteNode(head, 0);
        printLinkedList(newHead);
    }

    private static void printLinkedList (Node head) {
        while (head != null) {
            System.out.print(head.value + ",");
            head = head.next;
        }
        System.out.println();
    }

    private static Node deleteNode (Node head, int value) {
        Node newHead = head;
        //先找到新的起始点，如果开始的数就是要删除的数，就一直向后看，找到第一个不等的节点作为新的头
        while (newHead != null && newHead.value == value) {
            newHead = newHead.next;
        }
        //如果全是同一个数，就直接删空了
        if (newHead == null) {
            return newHead;
        }
        //遍历指针
        Node current = newHead;
        //上一个不相等的指针，比如删除32222链表里的2，此时current可能已经到了四号位了，但是应该从3开始连，保留一个prev
        Node prev = newHead;
        while (current != null) {

            if (current.value == value) {
                //相等时将前置连向自己的屁股
                prev.next = current.next;
            } else {
                //不相等说明不能删，将prev向前一个节点偏移
                prev = current;
            }
            current = current.next;
        }
        return newHead;
    }
}
