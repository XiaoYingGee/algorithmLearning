package com.xiaoyingge.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author XiaoYingGee
 * @date 2022/3/8 21:50
 */
public class Graph {

    private Map<Integer, GraphNode> nodeMap;
    private HashSet<GraphEdge> edges;

    public Graph() {
        nodeMap = new HashMap<>();
        edges = new HashSet<>();
    }

    public Map<Integer, GraphNode> getNodeMap() {
        return nodeMap;
    }

    public HashSet<GraphEdge> getEdges() {
        return edges;
    }
}
