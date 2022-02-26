package com.xiaoyingge.basic.class09;

import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import java.util.Stack;

/**
 * 判断一个单向链表是否是回文结构
 *
 * @author XiaoYingGee
 * @date 2022/2/26 14:23
 */
public class IsPalindromeList {

    public static void main(String[] args) {
        Node head = NodeUtil.createSimpleNodeList(new int[]{1, 2, 3, 4, 5, 3, 2, 1});
        boolean b = checkPalindrome(head);
        System.out.println(b);
    }

    private static boolean checkPalindrome(Node head) {
        //没有节点和只有一个 ，必回文
        if (head == null || head.getNext() == null) {
            return true;
        }
        //只有两个节点
        if (head.getNext().getNext() == null) {
            return head.getValue() == head.getNext().getValue();
        }
        Stack<Integer> stack = new Stack<>();
        Node oneStep = head;
        Node twoStep = head;
        while (twoStep.getNext() != null && twoStep.getNext().getNext() != null) {
            oneStep = oneStep.getNext();
            twoStep = twoStep.getNext().getNext();
        }
        //奇数情况，舍弃左半部+中点
        //偶数情况，舍弃左半部
        //这个反向思维很牛逼了
        oneStep = oneStep.getNext();
        while (oneStep != null) {
            stack.push(oneStep.getValue());
            oneStep = oneStep.getNext();
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != head.getValue()) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }
}
