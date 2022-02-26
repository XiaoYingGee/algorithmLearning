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

    private Node pre;
    private Node next;
    private int value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
