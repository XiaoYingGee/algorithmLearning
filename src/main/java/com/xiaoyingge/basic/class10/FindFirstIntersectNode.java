package com.xiaoyingge.basic.class10;

import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;

/**
 * 给定两个单链表的head,找出这两个链表相交的第一个点
 *
 * @author XiaoYingGee
 * @date 2022/2/26 23:07
 */
public class FindFirstIntersectNode {

    public static void main(String[] args) {
        Node one = buildRing(10, 4);

        Node two = buildRing(10, 4);
        getFirstPoint(one, two);

    }

    /**
     * @param one
     * @param two
     */
    private static Node getFirstPoint(Node one, Node two) {
        Node loop = findLoop(one);
        System.out.println(loop);
        Node loop2 = findLoop(two);
        System.out.println(loop2);
        //分四种场景
        if (loop != null && loop2 == null) {
            return null;
        } else if (loop == null && loop2 != null) {
            return null;
        } else if (loop == null && loop2 == null) {
            //这种如果相交一定是Y型或者V型
            return getPointFromY(one, two, null);
        } else {
            //如果相等，则与环无关
            if (loop == loop2) {
                return getPointFromY(one, two, loop);
            } else {
                Node tmp = loop.getNext();
                while (tmp != loop) {
                    if (tmp == loop2) {
                        return loop2;
                    }
                    tmp = tmp.getNext();
                }
                return null;
            }
        }
    }

    private static Node getPointFromY(Node one, Node two, Node end) {
        int n = 0;
        Node onePre = null;
        Node twoPre = null;
        while (one != end) {
            n++;
            onePre = one;
            one = one.getNext();
        }
        while (two != end) {
            n--;
            twoPre = two;
            two = two.getNext();
        }
        if (onePre != twoPre) {
            return null;
        }

        //先跑的放到这
        onePre = n > 0 ? one : two;
        //后跑的放这
        twoPre = n > 0 ? two : one;
        n = Math.abs(n);
        while (onePre != null) {
            if (onePre == twoPre) {
                return onePre;
            }
            onePre = onePre.getNext();
            if (n-- <= 0) {
                twoPre = twoPre.getNext();
            }

        }
        return null;
    }

    private static Node buildRing(int size, int joinIndex) {

        Node head = NodeUtil.createSimpleNodeList(size, 100);
        Node current = head;
        Node find = null;
        int count = 1;
        while (true) {
            if (count++ == joinIndex) {
                find = current;
            }
            if (current.getNext() == null) {
                current.setNext(find);
                break;
            }
            current = current.getNext();

        }
        return head;
    }

    /**
     * 查找链表是否成环
     *
     * @param head
     * @return
     */
    public static Node findLoop(Node head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        //如果是两个节点组成环，返回head
        if (head.getNext().getNext() != null && head.getNext().getNext() == head) {
            return head;
        }
        //要么是两个节点不成环，要么是三个以上结点
        Node slow = head.getNext();
        Node fast = head.getNext().getNext();
        boolean hasLoop = true;
        while (slow != fast) {
            //说明跑完整个链表了
            if (fast.getNext() == null || fast.getNext().getNext() == null) {
                hasLoop = false;
                break;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if (!hasLoop) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }
}
