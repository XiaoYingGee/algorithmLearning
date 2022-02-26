package com.xiaoyingge.basic.class03;

import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import com.xiaoyingge.util.PrintUtil;

/**
 * 反转链表
 *
 * @author XiaoYingGee
 * @date 2022/2/22 22:14
 */
public class ReverseList {

    public static void main(String[] args) {
        Node head = NodeUtil.createSimpleNodeList(10, 99);
        //反转单链表
        reverseSimpleList(head);

        Node head = NodeUtil.createDoubleNodeList(10, 99);
    }

    //简化一点，不考虑为空的情况
    private static void reverseSimpleList(Node head) {
        PrintUtil.print(head);

        Node pre = null;
        Node current = head;
        if (current.getNext() == null) {
            System.out.println("就一个结点，不必反转");
        }
        Node next = current.getNext();
        while (next != null) {
            current.setNext(pre);
            pre = current;
            current = next;
            next = current.getNext();
        }
        current.setNext(pre);
        PrintUtil.print(current);
    }
}
