package com.xiaoyingge.stack;

import java.util.TreeSet;

/**
 * 获取第K小的奇数
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/6/8 14:18
 */
public class GetRankKNumber {

    public static void main (String[] args) {
        int[] arr = new int[]{77, 5, 3, 5, 7, 5, 3, 45, 3, 1};
        System.out.println(new GetRankKNumber().getRankK(arr, 5));

    }

    public int getRankK (int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组有问题");
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            if ((i & 1) == 0) {
                continue;
            }

            if (set.size() > k) {
                if (set.last() < i) {
                    set.pollLast();
                }
            } else {
                set.add(i);
            }
        }
        return set.size() == 0 ? 0 : set.last();
    }

}
