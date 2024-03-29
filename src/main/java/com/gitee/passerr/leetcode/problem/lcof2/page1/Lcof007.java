package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？请找出所有和为 0 且不重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -10<sup>5</sup> <= nums[i] <= 10<sup>5</sup>
 * <p>
 * 注意：本题与主站 15题相同：https://leetcode.cn/problems/3sum/
 * @author xiehai
 * @date 2021/12/13 10:48
 */
public class Lcof007 {
    // #region snippet
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        // 数字排序
        Arrays.sort(nums);
        for (int i = 0; i < len - 1; i++) {
            // 数字大于0 直接退出 所有数字大于0和不可能为0
            if (nums[i] > 0) {
                break;
            }
            // 已经使用过的第一个数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int t = nums[left] + nums[right] + nums[i];
                if (t < 0) {
                    left++;
                } else if (t > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 第二个数字和当前解的第二个数字一样
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        
        return result;
    }
    // #endregion snippet
}
