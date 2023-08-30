package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 示例1:
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * <p>
 * 示例2:
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * <p>
 * 提示：
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 * @author xiehai
 * @date 2020/06/06 13:31
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0401 {
    // #region snippet
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 路径可达
        boolean[] dp = new boolean[n];

        for (int[] node : graph) {
            // 若出发地为start 则设置出发地到目的地可达
            dp[node[0]] = node[0] == start;
        }

        // 保证节点出发地是升序排序
        Arrays.sort(graph, Comparator.comparing(g -> g[0]));

        for (int[] node : graph) {
            if (dp[node[0]]) {
                dp[node[1]] = true;
            }
        }

        return dp[target];
    }

    public boolean findWhetherExistsPathDfs(int n, int[][] graph, int start, int target) {
        // 出发地集合
        Set<Integer> from = new HashSet<>();
        // 目的地及对应出发地
        Map<Integer, Set<Integer>> destination = new HashMap<>(8);
        for (int[] node : graph) {
            from.add(node[0]);
            destination.merge(node[1], new HashSet<>(Collections.singletonList(node[0])), (s0, s1) -> {
                s0.addAll(s1);
                return s0;
            });
        }

        // 不包含出发地或者目的地
        if (!from.contains(start) || !destination.containsKey(target)) {
            return false;
        }

        // 从目的地开始找出发地 找到则存在路径
        BiFunction<Integer, Set<Integer>, Boolean> recursion = new BiFunction<Integer, Set<Integer>, Boolean>() {
            @Override
            public Boolean apply(Integer t, Set<Integer> from) {
                if (from == null) {
                    return false;
                }

                if (from.contains(t)) {
                    return true;
                }

                for (Integer s : from) {
                    if (this.apply(t, destination.get(s))) {
                        return true;
                    }
                }

                return false;
            }
        };

        return recursion.apply(start, destination.get(target));
    }
    // #endregion snippet
}
