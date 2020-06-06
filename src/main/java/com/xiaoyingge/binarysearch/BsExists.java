package com.xiaoyingge.binarysearch;

/**
 * 一个不重复的数组，二分查找一个数
 * 因此只要二分后命中要的数 就可以停止计算
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/5/12 20:55
 */
public class BsExists {

    static int randomIndex = 0;

    public static void main (String[] args) {
        int[] arr = getArr();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == randomIndex) {
                System.out.println("found");
                System.out.println("left " + left + " right " + right);
                return;
            } else if (arr[mid] > randomIndex) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //这句也可以不写，把上面的while条件改为<=就可以
        if (arr[left] == randomIndex) {
            System.out.println("found");
        }
    }

    private static int[] getArr () {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        randomIndex = 9;
        return arr;
    }

}
