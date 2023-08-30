package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入： nums = [1,2,3]
 * 输出：
 * |[
 * |  [3],
 * |  [1],
 * |  [2],
 * |  [1,2,3],
 * |  [1,3],
 * |  [2,3],
 * |  [1,2],
 * |  []
 * |]
 * @author xiehai
 * @date 2020/07/31 13:09
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0804 {
    // #region snippet
    public List<List<Integer>> subsets(int[] nums) {
        // 把每个数组元素看做二进制某一位
        int length = nums.length, max = (int) Math.pow(2, length);
        // 子集的个数加上空集总为2^n个
        List<List<Integer>> result = new ArrayList<>();
        // 依次遍历每种组合 从0开始保证空集
        for (int i = 0; i < max; i++) {
            List<Integer> solution = new ArrayList<>();
            // 每个元素由低到高依次占位1
            for (int j = 0; j < length; j++) {
                // 第一个元素为1 第二个元素为10 第三个元素为100 第四个元素为1000依次类推
                // 符合该位置的
                if ((i & 1 << j) > 0) {
                    solution.add(nums[j]);
                }
            }
            result.add(solution);
        }

        return result;
    }
    // #endregion snippet
}
