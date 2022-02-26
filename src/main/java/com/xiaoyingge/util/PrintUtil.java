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
        while (pointer != null) {
            System.out.print(pointer.getValue() + " -> ");
            pointer = pointer.getNext();
        }
        System.out.println();
    }

}
