package com.gitee.passerr.leetcode.contest.season.fall2019;

import java.util.*;

/**
 * @author xiehai1
 * @date 2019/09/24 21:56
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Solution3 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int cx = 0, cy = 0;
        // 缓存x轴和y轴的障碍物
        Map<Integer, Set<Integer>> ox = new HashMap<>(8);
        Map<Integer, Set<Integer>> oy = new HashMap<>(8);
        for (int[] obstacle : obstacles) {
            ox.merge(obstacle[0], new HashSet<>(Collections.singleton(obstacle[1])), (o, n) -> {
                o.add(obstacle[1]);
                return o;
            });
            oy.merge(obstacle[1], new HashSet<>(Collections.singleton(obstacle[0])), (o, n) -> {
                o.add(obstacle[0]);
                return o;
            });
        }
        Set<Integer> temp;
        while (true) {
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    cx += 1;
                } else {
                    cy += 1;
                }
                if (cx > x || cy > y) {
                    return false;
                }
                if (cx == x && cy == y) {
                    return true;
                } else if (((temp = ox.get(cx)) != null) && temp.contains(cy)
                    || ((temp = oy.get(cy)) != null) && temp.contains(cx)) {
                    return false;
                }
            }
        }
    }
}
