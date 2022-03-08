package com.xiaoyingge.basic.class16;

import com.xiaoyingge.common.Graph;
import com.xiaoyingge.common.GraphNode;
import com.xiaoyingge.util.GraphUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * 图的深度优先遍历
 *
 * @author XiaoYingGee
 * @date 2022/3/8 22:35
 */
public class GraphDepthFirstSearch {

    public static void main(String[] args) {
        Graph graph = GraphUtil.generateRandomGraph();
        GraphNode randomNode = graph.getNodeMap().get(6);
        process(randomNode);
    }

    private static void process(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> set = new HashSet<>();
        System.out.println(node.getId());
        stack.push(node);
        set.add(node);
        while (!stack.isEmpty()) {
            GraphNode current = stack.pop();
            List<GraphNode> nexts = current.getNexts();
            for (GraphNode next : nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    System.out.println(next.getId());
                    stack.push(current);
                    stack.push(next);
                    break;
                }
            }

        }

    }
}
