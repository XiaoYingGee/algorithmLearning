package com.xiaoyingge.common;

/**
 * @author XiaoYingGee
 * @date 2022/3/8 21:49
 */
public class GraphEdge {

    private GraphNode from;
    private GraphNode to;
    private int weigh;

    public GraphEdge(GraphNode from, GraphNode to, int weigh) {
        this.from = from;
        this.to = to;
        this.weigh = weigh;
    }

    public GraphNode getFrom() {
        return from;
    }

    public void setFrom(GraphNode from) {
        this.from = from;
    }

    public GraphNode getTo() {
        return to;
    }

    public void setTo(GraphNode to) {
        this.to = to;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    @Override
    public String toString() {
        return this.weigh + "";
    }
}
