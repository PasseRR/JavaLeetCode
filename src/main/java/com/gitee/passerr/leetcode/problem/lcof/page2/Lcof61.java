package com.gitee.passerr.leetcode.problem.lcof.page2;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * @author xiehai
 * @date 2020/07/22 09:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int king = 0, start = 0;
        // 大小王个数
        while (nums[start] == 0 && start < 5) {
            start++;
            king++;
        }

        // 剩余扑克
        for (int i = start; i < 4; i++) {
            int minus = nums[i + 1] - nums[i];
            // 存在相同的扑克 不是顺子
            if (minus == 0) {
                return false;
            } else if (minus > 1) {
                // 差值超超过1的 使用大小王代替
                king -= minus - 1;
                if (king < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
