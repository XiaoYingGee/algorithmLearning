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
    }

    //简化一点，不考虑为空的情况
    private static void reverseSimpleList(Node head) {
        PrintUtil.print(head);

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;

        }
        PrintUtil.print(pre);
    }
}
