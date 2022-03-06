package com.xiaoyingge.basic.class14;

import java.util.Map;
import lombok.Data;

/**
 * 并查集
 *
 * @author XiaoYingGee
 * @date 2022/3/6 23:03
 */
public class UnionFindCollection {

    public static class UnionNode<T> {

        T node;

        public UnionNode(T t) {
            node = t;
        }
    }

    @Data
    public static class UnionFind<T> {

        private Map<T, UnionNode<T>> nodeMap;
        private Map<UnionNode<T>, UnionNode<T>> parentMap;
        private Map<UnionNode<T>, Integer> sizeMap;

        public UnionFind(T value) {
            UnionNode node = new UnionNode(value);
            nodeMap.put(value, node);
            parentMap.put(node, node);
            sizeMap.put(node, 1);
        }

        /**
         * 查找t1,t2是否在一个集合里
         *
         * @param t1
         * @param t2
         * @return
         */
        public boolean find(T t1, T t2) {
            UnionNode<T> parent1 = findParent(t1);
            UnionNode<T> parent2 = findParent(t2);
            return parent1 == parent2;
        }

        private UnionNode<T> findParent(T t) {
            UnionNode<T> node = nodeMap.get(t);
            while (parentMap.get(node) != node) {
                node = parentMap.get(node);
            }
            return node;
        }

        /**
         * 将t1.t2所在的集合合并起来
         *
         * @param t1
         * @param t2
         */
        public void union(T t1, T t2) {
            UnionNode<T> parent1 = findParent(t1);
            UnionNode<T> parent2 = findParent(t2);
            if (parent1 == parent2) {
                return;
            }
            int size1 = this.sizeMap.get(parent1);
            int size2 = this.sizeMap.get(parent2);
            if (size1 >= size2) {
                unionGroup(parent1, parent2);
            } else {
                unionGroup(parent2, parent1);
            }
        }

        private void unionGroup(UnionNode<T> large, UnionNode<T> small) {
            parentMap.put(small, large);
            sizeMap.put(large, sizeMap.get(large) + sizeMap.get(small));
            sizeMap.remove(small);
        }

    }
}
