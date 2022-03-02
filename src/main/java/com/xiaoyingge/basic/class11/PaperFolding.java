package com.xiaoyingge.basic.class11;

/**
 * 打印折纸问题
 * <p>
 * 将一张长纸条竖着拿，然后对折，折痕需要不指自己，记为DOWN 同样的手法继续对折，会出现 DOWN DOWN UP折痕 给定参数N代表对折N次，打印折痕
 *
 * @author XiaoYingGee
 * @date 2022/3/2 22:27
 */
public class PaperFolding {

    public static void main(String[] args) {

        print("DOWN", 1);
        System.out.println("=========================");
        print("DOWN", 2);
        System.out.println("=========================");
        print("DOWN", 3);
        System.out.println("=========================");
        print("DOWN", 4);
        System.out.println("=========================");

    }

    //对应一个N层的二叉树中序打印问题
    private static void print(String text, int level) {
        if (level == 0) {
            return;
        }
        print("DOWN", level - 1);
        System.out.println(text);
        print("UP", level - 1);
    }
}
