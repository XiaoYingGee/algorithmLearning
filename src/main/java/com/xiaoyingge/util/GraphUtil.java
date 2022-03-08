package com.xiaoyingge.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.xiaoyingge.common.Graph;
import com.xiaoyingge.common.GraphEdge;
import com.xiaoyingge.common.GraphNode;
import java.util.List;

/**
 * @author XiaoYingGee
 * @date 2022/3/8 21:52
 */
public class GraphUtil {

    /**
     * 类似于下面的数组表达的图
     * <p>【weight，fromNodeId，toNodeId】</p>
     * <p>【7，1，2】</p>
     *
     * @param nums
     * @return
     */
    public static Graph parse(int[][] nums) {
        Graph graph = new Graph();
        for (int[] num : nums) {
            int weight = num[0];
            int fromId = num[1];
            int toId = num[2];
            GraphNode fromNode = graph.getNodeMap().get(fromId);
            if (fromNode == null) {
                fromNode = new GraphNode(fromId);
                graph.getNodeMap().put(fromId, fromNode);
            }
            GraphNode toNode = graph.getNodeMap().get(toId);
            if (toNode == null) {
                toNode = new GraphNode(toId);
                graph.getNodeMap().put(toId, toNode);

            }
            GraphEdge edge = new GraphEdge(fromNode, toNode, weight);
            //图的边和点都加过了
            graph.getEdges().add(edge);
            //开始处理点
            fromNode.setOut(fromNode.getOut() + 1);
            toNode.setIn(toNode.getIn() + 1);
            fromNode.getEdges().add(edge);
            fromNode.getNexts().add(toNode);
        }
        return graph;
    }

    public static void main(String[] args) {
        List<String> input = Lists.newArrayList("2,1,4", "1,4,6", "2,5,6", "2,6,5", "9,5,2", "5,1,2",
                "3,3,1", "4,3,4");
        int[][] nums = new int[input.size()][3];
        for (int i = 0; i < input.size(); i++) {
            int j = 0;
            for (String s1 : Splitter.on(",").splitToList(input.get(i))) {
                nums[i][j++] = Integer.parseInt(s1);
            }
        }
        Graph graph = parse(nums);
        System.out.println(graph);
    }

    public static Graph generateRandomGraph() {
        List<String> input = Lists.newArrayList(
                "2,1,4", "2,4,1",
                "1,4,6", "1,6,4",
                "2,5,6", "2,6,5",
                "9,5,2", "9,2,5",
                "5,1,2", "5,2,1",
                "3,3,1", "3,1,3",
                "4,3,4", "4,4,3");
        int[][] nums = new int[input.size()][3];
        for (int i = 0; i < input.size(); i++) {
            int j = 0;
            for (String s1 : Splitter.on(",").splitToList(input.get(i))) {
                nums[i][j++] = Integer.parseInt(s1);
            }
        }
        return parse(nums);
    }
}

