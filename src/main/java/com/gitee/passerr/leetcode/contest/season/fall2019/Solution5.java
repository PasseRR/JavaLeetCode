package com.gitee.passerr.leetcode.contest.season.fall2019;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author xiehai1
 * @date 2019/09/24 23:15
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Solution5 {
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        Map<Integer, Integer> coins = new HashMap<>(8);
        Map<Integer, List<Integer>> cache = new HashMap<>(8);
        for (int[] ls : leadership) {
            cache.merge(ls[0], new ArrayList<>(Collections.singleton(ls[1])), (o, nw) -> {
                o.add(ls[1]);

                return o;
            });
        }

        BiConsumer<Integer, Integer> recursion = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer i, Integer num) {
                coins.merge(i, num, (o, nw) -> o + nw);
                List<Integer> members = cache.get(i);
                if (members != null) {
                    members.forEach(it -> this.accept(it, num));
                }
            }
        };

        Function<Integer, Integer> sum = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                int sum = coins.getOrDefault(i, 0);
                List<Integer> members = cache.get(i);
                if (members != null) {
                    for (Integer member : members) {
                        sum += this.apply(member);
                    }
                }

                return sum;
            }
        };

        List<Integer> result = new ArrayList<>();
        for (int[] operation : operations) {
            switch (operation[0]) {
                case 1: {
                    // 指定人
                    coins.merge(operation[1], operation[2], (o, nw) -> o + nw);
                    break;
                }
                case 2: {
                    recursion.accept(operation[1], operation[2]);
                    // 累加
                    break;
                }
                case 3: {
                    result.add(sum.apply(operation[1]) % 1000000007);
                    break;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
