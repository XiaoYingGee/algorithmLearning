package com.xiaoyingge.basic.class03;

import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import com.xiaoyingge.util.NumUtil;
import com.xiaoyingge.util.PrintUtil;

/**
 * 删除链表中给定的数据
 *
 * @author XiaoYingGee
 * @date 2022/2/26 12:52
 */
public class DeleteGivenValue {

    public static void main(String[] args) {
        int max = 5;
        Node head = NodeUtil.createSimpleNodeList(20, max);
        PrintUtil.print(head);
        int random = NumUtil.random(max);
        System.out.println(random);
        Node delete = delete(head, random);
        PrintUtil.print(delete);
    }

    /**
     * 获取考虑边界问题，即是否头部即相等，还是多个待删除的数据连在一起的情况
     *
     * @param head
     * @param random
     */
    private static Node delete(Node head, int random) {

        Node newHead = null;
        if (head == null) {
            return null;
        }
        while (head != null && head.getValue() == random) {
            newHead = head.getNext();
            //删除这个节点
            head.setNext(null);
            head = newHead;
        }
        //如果是这样，说明这个链表上的数据完全一样且删除的数也是这个数
        if (newHead == null) {
            return null;
        }
        //否则new header就是新头
        Node pre = head;
        while (head != null) {
            if (head.getValue() == random) {
                pre.setNext(head.getNext());
            } else {
                pre = head;
            }
            head = head.getNext();
        }

        return newHead;

    }
}
