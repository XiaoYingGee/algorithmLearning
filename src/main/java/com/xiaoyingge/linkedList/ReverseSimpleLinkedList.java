package com.xiaoyingge.linkedList;

import lombok.Data;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/5/14 11:19
 */
@Data
public class ReverseSimpleLinkedList {

    private static class Node {

        private int value;

        private Node next;
    }

    public Node reverseLinkedList (Node head) {
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main (String[] args) {
        Node node3 = new Node();
        node3.value = 3;

        Node node2 = new Node();
        node2.value = 2;
        node2.next = node3;

        Node node1 = new Node();
        node1.value = 1;
        node1.next = node2;
        Node head = node1;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        head = node1;
        ReverseSimpleLinkedList simpleLinkedList = new ReverseSimpleLinkedList();
        Node newHead = simpleLinkedList.reverseLinkedList(head);
        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }

    }

}
