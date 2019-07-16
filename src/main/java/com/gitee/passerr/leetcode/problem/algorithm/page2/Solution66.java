package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @author xiehai
 * @date 2019/07/16 13:17
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int carry = 0, length = digits.length;
        // 尾数加1
        digits[length - 1] += 1;
        // 累加进位
        for (int i = digits.length - 1; i >= 0; i--) {
            result.add((digits[i] + carry) % 10);
            carry = (digits[i] + carry) / 10;
        }
        // 存在高位进位 增加一个高位数
        if (carry > 0) {
            result.add(carry);
        }
        Collections.reverse(result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
