package com.xiaoyingge.basic.class03;

import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import com.xiaoyingge.util.PrintUtil;

/**
 * 双向链表的反转
 *
 * @author XiaoYingGee
 * @date 2022/2/26 12:29
 */
public class ReverseDoubleList {

    public static void main(String[] args) {
        Node head = NodeUtil.createDoubleNodeList(10, 99);
        PrintUtil.print(head);
        reverseDoubleList(head);
    }

    /**
     * 反转双向链表
     *
     * @param head
     */
    private static void reverseDoubleList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            
        }

    }
}
