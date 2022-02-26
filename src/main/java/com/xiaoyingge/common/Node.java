package com.xiaoyingge.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 链表的节点结构
 *
 * @author XiaoYingGee
 * @date 2022/2/22 22:15
 */
@SuperBuilder
@Data
@NoArgsConstructor
public class Node {

    // 1单向 2双向
    private int type;
    private Node pre;
    private Node next;
    private int value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Node simpleNode() {
        return Node.builder()
                .type(1)
                .build();
    }

    public static Node simpleNode(int value, Node next) {
        return Node.builder()
                .type(1)
                .next(next)
                .value(value)
                .build();
    }

    public static Node doubleNode() {
        return Node.builder()
                .type(2)
                .build();
    }

    public boolean isDoubleNode() {
        return this.type == 2;
    }
}
