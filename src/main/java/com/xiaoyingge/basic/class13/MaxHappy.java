package com.xiaoyingge.basic.class13;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 最大快乐值，每个员工拥有快乐值，且有直属下属 怎样办一个派对，让来的员工快乐值累加最高
 * <p>限制条件是请了上司，下发一定不来</p>
 *
 * @author XiaoYingGee
 * @date 2022/3/4 0:44
 */
public class MaxHappy {

    @Data
    public static class Employee {

        public int happy;
        public List<Employee> next = new ArrayList<>();
    }

    @Data
    @AllArgsConstructor
    public static class NodeInfo {

        private int yes;
        private int no;
    }

    public static NodeInfo getMaxHappy(Employee employee) {
        if (employee == null) {
            return new NodeInfo(0, 0);
        }
        //下属就全收集了
        List<NodeInfo> infos = new ArrayList<>();
        for (Employee e : employee.getNext()) {
            infos.add(getMaxHappy(e));
        }
        //自己的信息
        NodeInfo info = new NodeInfo(0, 0);
        //如果自己去，那下属只能不去
        info.setYes(infos.stream().mapToInt(NodeInfo::getNo).sum() + employee.getHappy());
        //如果自己不去,那下属可去 可不去
        int myNo = 0;
        for (NodeInfo nodeInfo : infos) {
            myNo += Math.max(nodeInfo.getNo(), nodeInfo.getYes());
        }
        info.setNo(myNo);
        return info;
    }
}
