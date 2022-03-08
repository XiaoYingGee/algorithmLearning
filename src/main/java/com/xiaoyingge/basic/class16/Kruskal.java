package com.xiaoyingge.basic.class16;

import com.xiaoyingge.common.Graph;
import com.xiaoyingge.common.GraphEdge;
import com.xiaoyingge.common.GraphNode;
import com.xiaoyingge.util.GraphUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 一个图的路径都有代价，找出一条路线，可以将所有点连通，且路线消耗的代价最低 使用并查集处理
 * <P>使用并查集处理</P>
 *
 * @author XiaoYingGee
 * @date 2022/3/8 23:03
 */
public class Kruskal {

    private static class UnionFind<V> {

        public void init(V node) {
            parentMap.put(node, node);
            sizeMap.put(node, 1);
        }

        private Map<V, V> parentMap = new HashMap<>();
        private Map<V, Integer> sizeMap = new HashMap<>();

        public boolean isSameSet(V v1, V v2) {
            V v1Parent = getParent(v1);
            V v2Parent = getParent(v2);
            return v1Parent == v2Parent;
        }

        private V getParent(V child) {
            HashSet<V> path = new HashSet<>();
            V parent = parentMap.get(child);
            while (parent != parentMap.get(parent)) {
                path.add(child);
                parent = parentMap.get(parent);
            }
            for (V v : path) {
                parentMap.put(v, parent);
            }
            return parent;
        }

        public void union(V v1, V v2) {
            V v1Parent = getParent(v1);
            V v2Parent = getParent(v2);
            if (v1Parent == v2Parent) {
                return;
            }

            int size1 = sizeMap.get(v1Parent);
            int size2 = sizeMap.get(v2Parent);

            if (size1 > size2) {
                parentMap.put(v2Parent, v1Parent);
                sizeMap.put(v1Parent, size1 + size2);
                sizeMap.remove(v2Parent);
            } else {
                parentMap.put(v1Parent, v2Parent);
                sizeMap.put(v2Parent, size1 + size2);
                sizeMap.remove(v1Parent);
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = GraphUtil.generateRandomGraph();
        List<GraphEdge> process = process(graph);
        System.out.println(process);
    }

    public static List<GraphEdge> process(Graph graph) {
        //将边从小到大排序
        PriorityQueue<GraphEdge> edges = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeigh));
        edges.addAll(graph.getEdges());
        UnionFind<GraphNode> unionFind = new UnionFind<>();

        for (GraphNode value : graph.getNodeMap().values()) {
            unionFind.init(value);
        }

        List<GraphEdge> edgeList = new ArrayList<>();
        while (!edges.isEmpty()) {
            GraphEdge edge = edges.poll();
            GraphNode from = edge.getFrom();
            GraphNode to = edge.getTo();
            if (!unionFind.isSameSet(from, to)) {
                edgeList.add(edge);
                unionFind.union(from, to);
            }
        }
        return edgeList;
    }

}
