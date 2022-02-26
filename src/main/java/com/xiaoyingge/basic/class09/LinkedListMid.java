package com.xiaoyingge.basic.class09;

import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import com.xiaoyingge.util.PrintUtil;

/**
 * 输入链表，计算中点
 *
 * @author XiaoYingGee
 * @date 2022/2/26 13:38
 */
public class LinkedListMid {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println("=======================");
            Node head = NodeUtil.createSimpleNodeList(i, 99);
            PrintUtil.print(head);
            Node mid = findMid(head);
            System.out.println("mid1=" + mid);
            Node mid2 = findMid2(head);
            System.out.println("mid2=" + mid2);
            Node mid3 = findMid3(head);
            System.out.println("mid3=" + mid3);
            Node mid4 = findMid4(head);
            System.out.println("mid4=" + mid4);
        }

    }

    /**
     * 奇数返回中点前一个，偶数返回下中点前一个（其实就是上中点） 方式就是双点右移一位
     *
     * @param head
     * @return
     */
    private static Node findMid4(Node head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        Node oneStep = head;
        Node twoStep = head.getNext();
        while (twoStep.getNext() != null && twoStep.getNext().getNext() != null) {
            oneStep = oneStep.getNext();
            twoStep = twoStep.getNext().getNext();
        }
        return oneStep;
    }

    /**
     * 奇数返回中点前一个，偶数返回上中点前一个 方式就是双点右移两位
     *
     * @param head
     * @return
     */
    private static Node findMid3(Node head) {
        //两个点之内  都是返回null;
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return null;
        }
        Node oneStep = head;
        Node twoStep = head.getNext().getNext();
        while (twoStep.getNext() != null && twoStep.getNext().getNext() != null) {
            oneStep = oneStep.getNext();
            twoStep = twoStep.getNext().getNext();
        }
        return oneStep;
    }

    /**
     * 如果是奇数长度，返回中点，如果是偶数长度，返回上中点 方式就是双跳的卡向右移一位
     *
     * @param head
     * @return
     */
    private static Node findMid(Node head) {

        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return head;
        }
        Node oneStep = head;
        Node twoStep = head;
        while (twoStep.getNext() != null && twoStep.getNext().getNext() != null) {
            oneStep = oneStep.getNext();
            twoStep = twoStep.getNext().getNext();
        }
        return oneStep;
    }

    /**
     * 如果是奇数长度，返回中点，如果是偶数长度，返回下中点
     *
     * @param head
     * @return
     */
    private static Node findMid2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node oneStep = head.getNext();
        Node twoStep = head.getNext();
        while (twoStep.getNext() != null && twoStep.getNext().getNext() != null) {
            oneStep = oneStep.getNext();
            twoStep = twoStep.getNext().getNext();
        }
        return oneStep;
    }
}
