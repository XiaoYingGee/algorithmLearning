package com.xiaoyingge.linkedList;

import com.xiaoyingge.linkedList.SimpleLinkedList.Node;
import lombok.Data;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/5/14 11:19
 */
@Data
public class ReverseSimpleLinkedList {

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
        Node newHead = new SimpleLinkedList().getRandomLinkedList(100, 100);
        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }

    }

}
