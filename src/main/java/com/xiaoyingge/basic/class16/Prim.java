package com.xiaoyingge.basic.class16;

import com.xiaoyingge.common.Graph;
import com.xiaoyingge.common.GraphEdge;
import com.xiaoyingge.common.GraphNode;
import com.xiaoyingge.util.GraphUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 一个图的路径都有代价，找出一条路线，可以将所有点连通，且路线消耗的代价最低
 * <P>使用小根堆</P>
 *
 * @author XiaoYingGee
 * @date 2022/3/8 23:25
 */
public class Prim {

    public static void main(String[] args) {
        Graph graph = GraphUtil.generateRandomGraph();
        List<GraphEdge> process = process(graph);
        System.out.println(process);
    }

    private static List<GraphEdge> process(Graph graph) {
        //取一个随机点
        GraphNode randomNode = graph.getNodeMap().get(4);
        //按边从小到大排,存放已解锁的边
        PriorityQueue<GraphEdge> edges = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeigh));
        edges.addAll(randomNode.getEdges());
        HashSet<GraphNode> usedNodes = new HashSet<>();

        List<GraphEdge> usedEdges = new ArrayList<>();
        usedNodes.add(randomNode);

        while (!edges.isEmpty()) {
            GraphEdge edge = edges.poll();
            if (!usedNodes.contains(edge.getTo())) {
                usedEdges.add(edge);
                usedNodes.add(edge.getTo());
                edges.addAll(edge.getTo().getEdges());
            }
        }
        return usedEdges;
    }
}
