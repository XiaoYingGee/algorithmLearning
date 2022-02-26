package com.xiaoyingge.util;

import com.xiaoyingge.common.Node;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author XiaoYingGee
 * @date 2022/2/22 22:21
 */
public class PrintUtil {

    public static void print(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.toList()));
    }

    public static void print(Node node) {
        Node pointer = node;
        boolean notEnd = true;
        boolean isDoubleNode = node.isDoubleNode();
        while (pointer != null) {
            System.out.print(pointer.getValue() + (notEnd ? " -> " : " <- "));
            if (pointer.getNext() == null && isDoubleNode && notEnd) {
                notEnd = false;
                System.out.println();
                System.out.print(pointer.getValue() + " <- ");
            }
            pointer = notEnd ? pointer.getNext() : pointer.getPre();

        }
        System.out.println();
    }

}
