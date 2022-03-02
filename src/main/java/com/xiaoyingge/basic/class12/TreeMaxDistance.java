package com.xiaoyingge.basic.class12;

import com.xiaoyingge.common.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 给定一个树，返回树上的最远距离，即两个点间的间距
 *
 * @author XiaoYingGee
 * @date 2022/3/2 23:21
 */
public class TreeMaxDistance {

    @Data
    @AllArgsConstructor
    private static class NodeInfo {

        private int max;

        private int level;
    }

    private static NodeInfo process(Node node) {
        if (node == null) {
            return new NodeInfo(0, 0);
        }

        NodeInfo left = process(node.getLeft());
        NodeInfo right = process(node.getRight());

        int level = Math.max(left.getLevel(), right.getLevel()) + 1;
        //不经过当前点的情况
        int maxWithoutMe = Math.max(left.getMax(), right.getMax());
        //经过当前点的情况
        int maxWithMe = left.getLevel() + right.getLevel() + 1;

        return new NodeInfo(Math.max(maxWithMe, maxWithoutMe), level);
    }

}
