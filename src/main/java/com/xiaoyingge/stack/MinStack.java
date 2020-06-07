package com.xiaoyingge.stack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) – 将元素 x 推入栈中。
 * pop() – 删除栈顶的元素。
 * top() – 获取栈顶元素。
 * getMin() – 检索栈中的最小元素。
 *
 * @author Xiaoyingge
 * @description
 * @date 2020/6/7 19:59
 */
public class MinStack {

    private Stack<Integer> normal = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push (Integer x) {
        //最小栈为空或者最小栈栈顶小于当前值，压栈
        if (minStack.size() == 0 || minStack.peek() >= x) {
            minStack.push(x);
        }
        //存入
        normal.push(x);
    }

    public Integer pop () {
        Integer pop = normal.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
        return pop;
    }

    public Integer top () {
        return normal.peek();
    }

    public Integer getMin () {
        return minStack.peek();
    }

    public static void main (String[] args) {

        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(9);
        stack.push(2);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(2);
        stack.push(4);

        System.out.println(stack.getMin());
        System.out.println(stack.top());
        System.out.println("==================");
        for (int i = 0; i < 10; i++) {
            System.out.print("pop:" + stack.pop());
            System.out.print(",min:+" + (stack.minStack.empty() ? null : stack.getMin()));
            System.out.println();

        }

    }
}
