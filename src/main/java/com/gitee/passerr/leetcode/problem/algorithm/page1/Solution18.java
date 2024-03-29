package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * @author xiehai
 * @date 2019/07/03 12:41
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution18 {
    // #region snippet
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>(8);
        Arrays.sort(nums);
        // 类似三数和 多一个固定位
        // 头部节点
        for (int i = 0, length = nums.length; i < length; i++) {
            // 尾部节点
            for (int j = length - 1; j >= 0; j--) {
                // 头部向中间遍历
                int k = i + 1;
                // 尾部向中间遍历
                int l = j - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        set.add(
                            Arrays.stream(new int[]{nums[i], nums[j], nums[k], nums[l]})
                                .boxed()
                                .sorted()
                                .collect(Collectors.toList())
                        );
                        l--;
                        k++;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
    // #endregion snippet
}
