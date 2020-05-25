package com.xiaoyingge.longestconsecutivesequence;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 找到最长连续序列
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/22 11:00
 */
public class LongestConsecutiveSequence {

    private static final Integer[] ARR = new Integer[]{100, 4, 200, 1, 3, 2};

    public static void main (String[] args) {
        //遍历N次
        HashSet<Integer> set = new HashSet<>(Arrays.asList(ARR));
        int result = 1;
        //总共遍历N次
        for (Integer i : ARR) {
            if (set.remove(i)) {
                int sum = 1;
                int left = i - 1;
                int right = i + 1;
                //通过O(1)复杂度的hash表来加快
                while (set.remove(left--)) {
                    sum++;
                }
                while (set.remove(right--)) {
                    sum++;
                }
                result = Math.max(result, sum);
            }
        }
        //复杂度o(2n) = o(n)
        System.out.println(result);

    }
}
