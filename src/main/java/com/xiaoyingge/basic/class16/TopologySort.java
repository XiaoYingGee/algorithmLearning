package com.xiaoyingge.basic.class16;

import com.xiaoyingge.common.Graph;
import com.xiaoyingge.common.GraphNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 对于给定的有向无环图，给出拓扑排序
 *
 * @author XiaoYingGee
 * @date 2022/3/8 22:52
 */
public class TopologySort {

    public static void process(Graph graph) {
        Queue<GraphNode> queue = new LinkedList<>();
        Map<GraphNode, Integer> inMap = new HashMap<>();
        for (GraphNode node : graph.getNodeMap().values()) {
            inMap.put(node, node.getIn());
            if (node.getIn() == 0) {
                queue.add(node);
            }
        }
        List<GraphNode> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            GraphNode poll = queue.poll();
            result.add(poll);
            for (GraphNode node : poll.getNexts()) {
                int inTimes = inMap.get(node) - 1;
                inMap.put(node, inTimes);
                if (inTimes == 0) {
                    queue.add(node);
                }
            }

        }

    }

}
