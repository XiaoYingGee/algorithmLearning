package com.xiaoyingge.basic.class13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 给点一个字符串数组，将其拼接为一个最小字典序
 *
 * @author XiaoYingGee
 * @date 2022/3/6 21:37
 */
public class LowestLexicography {

    public static void main(String[] args) {
        String[] strs = new String[]{"a", "b", "c"};
        TreeSet<String> treeSet = processOne(strs);
        System.out.println(treeSet.first());
        String result = processTwo(strs);
        System.out.println(result);
    }

    //暴力求解
    private static TreeSet<String> processOne(String[] strs) {
        TreeSet<String> answer = new TreeSet<>();
        if (strs.length == 0) {
            answer.add("");
            return answer;
        }
        for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            String[] newArray = delete(strs, i);
            TreeSet<String> next = processOne(newArray);
            for (String s : next) {
                answer.add(current + s);
            }
        }
        return answer;
    }

    //如果AB < BA,则将A放左边
    //借用比较器来进行排序
    private static String processTwo(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new StrComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    private static class StrComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    private static String[] delete(String[] strs, int index) {
        if (strs.length == 0) {
            return new String[]{};
        }
        String[] newStrings = new String[strs.length - 1];
        for (int i = 0, j = 0; i < strs.length; i++) {
            if (i != index) {
                newStrings[j++] = strs[i];
            }
        }
        return newStrings;
    }

}
