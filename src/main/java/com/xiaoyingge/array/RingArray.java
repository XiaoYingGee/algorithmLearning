package com.xiaoyingge.array;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Xiaoyingge
 * @description
 * @date 2020/6/7 19:03
 */
public class RingArray<T> {

    public int size;

    public int maxSize;

    public int headIndex = 0;

    public int tailIndex = 0;

    public ArrayList<T> list;

    public static void main (String[] args) {
        RingArray<Integer> integerRingArray = new RingArray<>(10);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            integerRingArray.push(random.nextInt(10));
//            System.out.println("head:" + integerRingArray.headIndex + ",tail:" + integerRingArray.tailIndex);
        }
        System.out.println("==============");
        for (int i = 0; i < 2; i++) {
            integerRingArray.pop();
//            System.out.println("head:" + integerRingArray.headIndex + ",tail:" + integerRingArray.tailIndex);
        }
        System.out.println("==============");
        for (int i = 0; i < 11; i++) {
            integerRingArray.push(random.nextInt(10));
//            System.out.println("head:" + integerRingArray.headIndex + ",tail:" + integerRingArray.tailIndex);
        }
        System.out.println("==============");
        for (int i = 0; i < 5; i++) {
            integerRingArray.pop();
//            System.out.println("head:" + integerRingArray.headIndex + ",tail:" + integerRingArray.tailIndex);
        }
        System.out.println("==============");
        for (int i = 0; i < 3; i++) {
            integerRingArray.push(random.nextInt(10));
//            System.out.println("head:" + integerRingArray.headIndex + ",tail:" + integerRingArray.tailIndex);
        }
        System.out.println("==============");
        for (int i = 0; i < 8; i++) {
            integerRingArray.pop();
//            System.out.println("head:" + integerRingArray.headIndex + ",tail:" + integerRingArray.tailIndex);
        }
    }

    public RingArray (int maxSize) {
        list = new ArrayList<T>(maxSize);
        this.maxSize = maxSize;
    }

    public void push (T obj) {
        if (size == maxSize) {
            System.out.println("放满了,现在不准放");
            return;
        }
        if (list.size() < maxSize) {
            list.add(headIndex, obj);
        } else {
            list.set(headIndex, obj);
        }
        System.out.println("放了" + obj);
        updateHeadIndex();
        size++;
    }

    public T pop () {
        if (size == 0) {
            System.out.println("没货了兄弟");
            return null;
        }
        T value = list.get(tailIndex);
        list.set(tailIndex, null);
        size--;
        updateTailIndex();
        System.out.println("弹出" + value);
        return value;
    }

    private void updateTailIndex () {
        if (tailIndex + 1 == maxSize) {
            tailIndex = 0;
            return;
        }
        tailIndex++;
    }

    private void updateHeadIndex () {
        if (headIndex + 1 == maxSize) {
            headIndex = 0;
            return;
        }
        headIndex++;
    }

}
