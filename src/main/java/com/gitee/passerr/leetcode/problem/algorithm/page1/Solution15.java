package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @author xiehai
 * @date 2019/07/02 16:42
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 去重
        Set<List<Integer>> result = new HashSet<>();
        // 数组转list并升序排序
        // 去重 每个数字最多3个
        List<Integer> list = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)))
            .entrySet()
            .stream()
            .flatMap(entry -> {
                Integer[] array = new Integer[entry.getValue() > 2 ? 3 : entry.getValue()];
                Arrays.fill(array, entry.getKey());
                return Stream.of(array);
            })
            .sorted()
            .collect(Collectors.toList());

        // 类似快排的方式找到三个和为0的数字
        for (int i = 0, length = list.size(); i < length; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k && k > i) {
                int iv = list.get(i), jv = list.get(j), kv = list.get(k);
                if (iv + jv + kv < 0) {
                    j++;
                } else if (iv + jv + kv > 0) {
                    k--;
                } else {
                    result.add(Arrays.stream(new int[]{iv, jv, kv}).boxed().sorted().collect(Collectors.toList()));
                    j++;
                    k--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
