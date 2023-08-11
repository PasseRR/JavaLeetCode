package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 *  
 * 限制：
 * 1 <= n < 2^31
 * 注意：本题与主站 233 题相同：https://leetcode.cn/problems/number-of-digit-one/
 * @author xiehai
 * @date 2020/07/14 13:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof43 {
    public int countDigitOne(int n) {
        int count = 0;
        // 从个位开始遍历到最高位
        long i = 1;
        while (n / i != 0) {
            // 高于i位的数字
            long high = n / (10 * i);
            // i位数字
            long cur = (n / i) % 10;
            // 低于i位数字
            long low = n - (n / i) * i;
            // 当前位为0 只计算高位的0
            if (cur == 0) {
                count += high * i;
            } else if (cur == 1) {
                // 当前位为1 则高位加低位
                count += high * i + (low + 1);
            } else {
                // 当前位大于1
                count += (high + 1) * i;
            }

            // 进位
            i *= 10;
        }

        return count;
    }
}
