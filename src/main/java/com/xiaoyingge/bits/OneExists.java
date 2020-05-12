package com.xiaoyingge.bits;

import java.util.Random;

/**
 * 一个数组里只有一个数出现奇数次，找出来
 * 主要思想是 N^N=0 n^0=n
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 20:29
 */
public class OneExists {

    static int trueAnswer = 0;

    public static void main (String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] arr = getArr();
            int answer = 0;
            for (int j = 0; j < arr.length; j++) {
                answer ^= arr[j];
            }
            if (answer != trueAnswer) {
                System.out.println("fuck");
                break;
            }
        }
        System.out.println("搞定");
    }

    private static int[] getArr () {
        Random random = new Random();
        trueAnswer = random.nextInt(100000) - random.nextInt(100000);
        int answerAppearTimes = (random.nextInt(100) << 1) | 1;
        int num1 = random.nextInt(100000) - random.nextInt(100000);
        int num1AppearTimes = (random.nextInt(100) << 1);
        int num2 = random.nextInt(100000) - random.nextInt(100000);
        int num2AppearTimes = (random.nextInt(100) << 1);
        int[] result = new int[answerAppearTimes + num1AppearTimes + num2AppearTimes];
        for (int i = 0; i < num1AppearTimes; i++) {
            result[i] = num1;
        }
        for (int i = num1AppearTimes; i < num1AppearTimes + num2AppearTimes; i++) {
            result[i] = num2;
        }
        for (int i = num1AppearTimes + num2AppearTimes; i < num1AppearTimes + num2AppearTimes + answerAppearTimes; i++) {
            result[i] = trueAnswer;
        }
        return result;
    }

}
