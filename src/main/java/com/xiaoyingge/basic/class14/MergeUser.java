package com.xiaoyingge.basic.class14;

import java.util.Map;
import lombok.Data;

/**
 * 合并用户，假设用户有三个属性 a b c  任意两个用户有一个属性相等则认为是同一用户 ，给出一个用户集合，返回这里面一共多少用户
 *
 * @author XiaoYingGee
 * @date 2022/3/7 22:35
 */
public class MergeUser {

    private static Map<User, UserNode> nodeMap;
    private static Map<UserNode, UserNode> parentMap;
    private static Map<UserNode, Integer> sizeMap;
    private static Map<String, UserNode> aMap;
    private static Map<String, UserNode> bMap;
    private static Map<String, UserNode> cMap;

    @Data
    private static class User {

        private String a;
        private String b;
        private String c;

        public boolean equals(User one, User two) {
            return one.getA().equals(two.getA()) || one.getB().equals(two.getB()) || one.getC().equals(two.getC());
        }
    }

    public static void main(String[] args) {
        User[] users = new User[]{};
        process(users);
    }

    @Data
    private static class UserNode {

        private User user;

        public UserNode(User u) {
            this.user = u;
        }
    }

    private static void process(User[] users) {
        Integer length = users.length;
        for (User user : users) {
            init(length, user);
        }
        System.out.println(length);
    }

    private static void init(Integer length, User user) {
        UserNode userNode = new UserNode(user);
        nodeMap.put(user, userNode);
        parentMap.put(userNode, userNode);
        boolean find = false;
        if (aMap.containsKey(user.getA())) {
            find = true;
            UserNode aParent = aMap.get(user.getA());
            parentMap.put(userNode, aParent);
        } else {
            aMap.put(user.getA(), userNode);
        }
        if (bMap.containsKey(user.getB())) {
            find = true;
            UserNode bParent = bMap.get(user.getB());
            parentMap.put(userNode, bParent);
        } else {
            bMap.put(user.getB(), userNode);
        }
        if (cMap.containsKey(user.getC())) {
            find = true;
            UserNode bParent = cMap.get(user.getC());
            parentMap.put(userNode, bParent);
        } else {
            cMap.put(user.getC(), userNode);
        }
        if (find) {
            length = length--;
        }
    }

}
