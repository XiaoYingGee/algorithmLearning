package com.xiaoyingge.basic.class09;

import com.xiaoyingge.common.Node;
import com.xiaoyingge.util.NodeUtil;
import com.xiaoyingge.util.NumUtil;
import com.xiaoyingge.util.PrintUtil;

/**
 * 针对数组和输入参数，组织成小于在左 等于在中  大于在右的结构
 *
 * @author XiaoYingGee
 * @date 2022/2/26 22:35
 */
public class ListPartition {

    public static void main(String[] args) {
        int max = 10;
        Node head = NodeUtil.createSimpleNodeList(10, max);
        int random = NumUtil.random(max);
        PrintUtil.print(head);
        System.out.println(random);
        Node newHead = partition(head, random);
        PrintUtil.print(newHead);
    }

    private static Node partition(Node head, int random) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node smallHead = null;
        Node smallTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node largeHead = null;
        Node largeTail = null;
        Node current = head;
        while (current != null) {
            if (current.getValue() < random) {  //小于区处理逻辑
                if (smallHead == null) {
                    smallHead = current;
                } else {
                    smallTail.setNext(current);
                }
                smallTail = current;
                current = current.getNext();
                smallTail.setNext(null);
                continue;
            } else if (current.getValue() == random) { //等于区处理逻辑
                if (equalHead == null) {
                    equalHead = current;
                } else {
                    equalTail.setNext(current);
                }
                equalTail = current;
                current = current.getNext();
                equalTail.setNext(null);
                continue;
            } else { //大于区处理逻辑
                if (largeHead == null) {
                    largeHead = current;
                } else {
                    largeTail.setNext(current);
                }
                largeTail = current;
                current = current.getNext();
                largeTail.setNext(null);
                continue;
            }

        }
        //拼接结果
        current = smallHead == null ? equalHead : smallHead;
        //为空说明没有小于区和等于区，只存在大于区，直接返回大于区的头
        if (current == null) {
            return largeHead;
        }
        //下面就是必有小于区或者必有等于区了

        //如果等于区没有头，说明数字没命中，且存在小于区，
        if (equalHead == null) {
            //说明同时存在小于区和大于区，需要连接上
            //检查存在大于区不，不存在就说明只有小于区
            if (largeHead != null) {
                smallTail.setNext(largeHead);
            }
            //走到这有两个可能
            // 1.大于区没货，说明只有小于区，返回头即可
            // 2.大于区有货，且上面已经连上，返回头即可
            return smallHead;
        } else if (smallHead == null) {
            //说明存在等于区，没有小于区
            if (largeHead != null) {
                equalTail.setNext(largeHead);
            }
            return equalHead;
        } else {
            //即同时存在小于和等于区
            smallTail.setNext(equalHead);
            if (largeHead != null) {
                equalTail.setNext(largeHead);
            }
            return smallHead;
        }

    }

}
