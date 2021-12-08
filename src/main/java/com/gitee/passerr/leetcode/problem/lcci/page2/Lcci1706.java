package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * 示例:
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * <p>
 * 提示：
 * n <= 10^9
 * @author xiehai
 * @date 2021/03/26 17:12
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.lcof1.page1.Lcof43
 */
public class Lcci1706 {
    public int numberOf2sInRange(int n) {
        int count = 0, carry = 1;

        // 依次判断数字每一位可能产生2的个数
        while (n / carry > 0) {
            // 高于carry位的数字
            int high = n / (10 * carry);
            // 当前位的数字
            int cur = (n / carry) % 10;
            // 低于carry位数字
            int low = n - (n / carry) * carry;

            // 当前位小于2
            if (cur < 2) {
                count += high * carry;
            } else if (cur == 2) {
                // 当前位为2 则高位加低位
                count += high * carry + (low + 1);
            } else {
                // 当前位大于2
                count += (high + 1) * carry;
            }

            carry *= 10;
        }

        return count;
    }
}
