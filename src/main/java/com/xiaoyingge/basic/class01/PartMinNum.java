package com.xiaoyingge.basic.class01;

import com.xiaoyingge.util.NumUtil;
import com.xiaoyingge.util.PrintUtil;

/**
 * 样本类型为左右数字不相同的乱序数组
 * <p>使用二分法查找局部最小，任意均可 </p>
 *
 * @author XiaoYingGee
 * @date 2022/2/22 21:42
 */
public class PartMinNum {

    public static void main(String[] args) {
        int[] arr = NumUtil.createRandomArray(30, 10);
        int index = search(arr, 0, arr.length - 1);
        PrintUtil.print(arr);
        System.out.println(index);
    }

    private static int search(int[] arr, int left, int right) {
        //只有一个端点
        if (left == right) {
            return left;
        }
        //看开头是不是升序
        if (arr[left] < arr[left + 1]) {
            return 0;
        }
        //看结尾是不是升序
        if (arr[right] < arr[right - 1]) {
            return right - 1;
        }
        //前面的可能性都排除之后,剩下的只有两侧向下
        int mid = left + ((right - left) >> 1);
        while (left < right) {

            if (arr[mid] > arr[mid - 1]) {
                //如果中点的左侧是上升趋势，用左点和它形成下一区间
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                //如果中点右侧是下降趋势，用右点和它形成下一区间
                left = mid + 1;
            } else {
                //条件一不满足的时候说明左侧是下降趋势
                //条件二不满足的时候说明右侧是上升趋势
                //则当前的点就是一个低点
                return mid;
            }
        }
        return left;
    }

}
