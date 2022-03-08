package com.xiaoyingge.basic.class16;

import com.xiaoyingge.common.Graph;
import com.xiaoyingge.common.GraphNode;
import com.xiaoyingge.util.GraphUtil;
import com.xiaoyingge.util.NumUtil;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.collections4.MapUtils;

/**
 * 图的宽度优先遍历
 *
 * @author XiaoYingGee
 * @date 2022/3/8 21:46
 */
public class GraphBreadthFirstSearch {

    public static void main(String[] args) {
        Graph graph = GraphUtil.generateRandomGraph();
        process(graph);
    }

    private static void process(Graph graph) {
        if (graph == null || MapUtils.isEmpty(graph.getNodeMap())) {
            return;
        }
        GraphNode randomNode = graph.getNodeMap().get(NumUtil.random(graph.getNodeMap().size() - 1));
        Queue<GraphNode> queue = new LinkedList<>();
        HashSet<GraphNode> set = new HashSet<>();
        set.add(randomNode);
        queue.add(randomNode);
        while (!queue.isEmpty()) {
            GraphNode poll = queue.poll();
            System.out.println(poll.getId());
            for (GraphNode next : poll.getNexts()) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }

            }
        }

    }
}
