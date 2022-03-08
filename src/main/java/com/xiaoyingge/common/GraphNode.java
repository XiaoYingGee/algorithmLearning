package com.xiaoyingge.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoYingGee
 * @date 2022/3/8 21:47
 */
public class GraphNode {

    private int id;
    private int out;
    private int in;

    private List<GraphNode> nexts;
    private List<GraphEdge> edges;

    public GraphNode(int id) {
        this.id = id;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getOut() {
        return out;
    }

    public int getIn() {
        return in;
    }

    public List<GraphNode> getNexts() {
        return nexts;
    }

    public List<GraphEdge> getEdges() {
        return edges;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public void setNexts(List<GraphNode> nexts) {
        this.nexts = nexts;
    }

    public void setEdges(List<GraphEdge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return this.id + "";
    }
}
