package com.xiaoyingge.basic.class14;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * <p> 点灯问题，输入一个字符串，由.和X组成 </p>
 * <p> .代表这是一个居民区，需要被点亮</p>
 * <p> X代表这是一个墙，不能放灯，不可以被点亮</p>
 * <p> 居民区是可以放灯的，并且不光照亮自己，还照亮前后，</p>
 * <p>问最少需要几个灯来点亮街道</p>
 *
 * @author XiaoYingGee
 * @date 2022/3/6 22:14
 */
public class Light {

    public static void main(String[] args) {
        String s = "...xxx.x.x...xxx..x.xxx.x.xx.x...xxx.x..x";
        int result1 = process1(s);
        System.out.println(result1);
        int result2 = process2(s);
        System.out.println(result2);
    }

    private static int process2(String s) {
        if (StringUtils.isBlank(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        int index = 0;
        while (index < chars.length) {
            if (chars[index] == 'x') {
                index = index + 1;
                continue;
            }
            //一种情况 右边直接到了边界
            if (index + 1 == chars.length) {
                count++;
                return count;
            }
            //没到边界的情况，右边是个X
            if (chars[index + 1] == 'x') {
                //当前位置必须放
                count++;
                index = index + 2;
            } else {
                //或者右边是个点，那么在右边放个灯，跳过三个点
                count++;
                index = index + 3;
            }
        }
        return count;
    }

    /**
     * 暴力解法，将所有点亮与不亮均计算进去，最后返回能成功点亮的结果
     *
     * @param s
     * @return
     */
    private static int process1(String s) {
        if (StringUtils.isBlank(s)) {
            return 0;
        }
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            list = calc(list, aChar);
        }
        int min = Integer.MAX_VALUE;
        for (String s1 : list) {
            min = Math.min(min, checkAnswer(s1));
        }
        return min;
    }

    /**
     * 全量的答案，是有可能出错的，错误的返回0，正确的返回有多少个y
     *
     * @param s1
     */
    private static int checkAnswer(String s1) {
        int length = s1.length();
        char[] chars = s1.toCharArray();
        int count = 0;
        int index = 0;
        while (index < length) {
            //如果当前是墙，则不用管，向右移动
            if (chars[index] == 'x') {
                index = index + 1;
                continue;
            }
            //如果当前点是亮的，则可以跳过这个点和右边点
            if (chars[index] == 'y') {
                count++;
                index = index + 2;
                continue;
            }
            //如果当前点是灭的，则右边必须得是亮的
            if (chars[index] == 'n' && index + 1 < length && chars[index + 1] == 'y') {
                count++;
                index = index + 3;
                continue;
            }
            return Integer.MAX_VALUE;
        }
        return count;
    }

    /**
     * 如果achar=x则计x，如果点亮计y，不点亮计n
     *
     * @param list
     * @param aChar
     */
    private static List<String> calc(List<String> list, char aChar) {
        if (list.size() == 0) {
            list.add("");
        }
        List<String> newList = new ArrayList<>(list.size() * 2);
        if (aChar == 'x') {
            for (String str : list) {
                newList.add(str + "x");
            }
        } else {
            for (String s : list) {
                //
                newList.add(s + "y");
                newList.add(s + "n");
            }
        }
        return newList;
    }
}
