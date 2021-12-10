package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * @author xiehai
 * @date 2019/08/01 10:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof004 {
    public int singleNumber(int[] nums) {
        int result = 0;

        // 从第31位开始 符号位也要判断
        for (int i = 31; i >= 0; i--) {
            int cnt = 0, bit = 1 << i;
            for (int num : nums) {
                // 来判断位元是否为0 若存在符号位 结果为负数
                if ((bit & num) != 0) {
                    cnt++;
                }
            }

            // 计算int所有为中1出现的次数 对3取余 剩余的就是只出现了一次的数字
            if (cnt % 3 != 0) {
                // 数字累加
                result |= bit;
            }
        }

        return result;
    }
}
