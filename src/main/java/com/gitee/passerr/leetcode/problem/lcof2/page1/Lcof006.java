package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0开始计数 ，
 * 所以答案数组应当满足 0<= answer[0] < answer[1] < numbers.length。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 * 示例 1：
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * <p>
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * <p>
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * <p>
 * 注意：本题与主站 167 题相似（下标起点不同）：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author xiehai
 * @date 2021/12/13 10:29
 */
public class Lcof006 {
    public int[] twoSum(int[] numbers, int target) {
        // 使用双指针遍历
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int t = numbers[i] + numbers[j];
            if (t == target) {
                return new int[]{i, j};
            } else if (t > target) {
                j--;
            } else {
                i++;
            }
        }

        // 根据题意肯定有解
        return null;
    }
}
