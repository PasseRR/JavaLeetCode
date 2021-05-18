package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 * @author xiehai
 * @date 2021/05/17 17:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1710 {
    public int majorityElement(int[] nums) {
        // result为结果数字 count为比其他数字加起来多的数量
        int result = -1, count = 0;
        // 摩尔投票 在必然存在众数的时候 算法正确
        // 当存在众数时 投票结果是正确的 投票结果为1的时候可能不存在众数时
        for (int num : nums) {
            if (count == 0) {
                result = num;
                count++;
            } else if (result != num) {
                count--;
            } else {
                count++;
            }
        }

        // 再次计算出现的次数是否大于一半
        if (count > 0) {
            int cnt = 0;
            for (int num : nums) {
                if (num == result) {
                    cnt++;
                }
            }

            if (cnt > nums.length / 2.0F) {
                return result;
            }
        }

        return -1;
    }
}
