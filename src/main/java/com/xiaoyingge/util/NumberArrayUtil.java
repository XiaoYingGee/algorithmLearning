package com.xiaoyingge.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 数组生成器
 *
 * @author XiaoYingGee
 * @date 2022/2/19 17:58
 */
public class NumberArrayUtil {

    public static int[] createRandomArray(int nums) {
        return createRandomArray(nums, Integer.MAX_VALUE);
    }

    public static int[] createRandomArray(int nums, int max) {
        SecureRandom random = createRandom();
        int[] result = new int[nums];
        for (int i = 0; i < nums; i++) {
            result[i] = random.nextInt(max);
        }
        return result;
    }

    private static SecureRandom createRandom() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int[] copy(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static void compare(int[] arr, int[] test) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != test[i]) {
                throw new RuntimeException("数据不一致");
            }
        }
    }
}
