package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定两个 01 字符串a和b，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字1和0。
 * <p>
 * 示例1:
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * <p>
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * @author xiehai
 * @date 2021/12/10 14:37
 */
public class Lcof002 {
    public String addBinary(String a, String b) {
        // a、b的长度 a、b和的最大长度
        int len1 = a.length(), len2 = b.length(), max = Integer.max(len1, len2) + 1;
        // 倒叙计算开始索引
        int i = len1 - 1, j = len2 - 1;
        // 二进制和字符位数
        int cnt = 0;
        // 结果字符数组
        char[] result = new char[max];
        // 进位标识
        boolean carry = false;
        
        while (i >= 0 || j >= 0) {
            // 计算相同未计算的最低位
            int t = (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0) + (carry ? 1 : 0);
            // 是否需要进位
            carry = t > 1;
            result[max - (cnt++) - 1] = (char) ('0' + (t % 2));
            i--;
            j--;
        }

        // 剩余进位
        if (carry) {
            result[max - (cnt++) - 1] = '1';
        }

        return new String(result, max - cnt, cnt);
    }
}
