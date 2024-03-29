package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.Arrays;

/**
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的某个变位词。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 * 示例 1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 10<sup>4</sup>
 * s1 和 s2 仅包含小写字母
 * <p>
 * 注意：本题与主站 567题相同：https://leetcode.cn/problems/permutation-in-string/
 * @author xiehai
 * @date 2021/12/16 15:58
 */
public class Lcof014 {
    // #region snippet
    public boolean checkInclusion(String s1, String s2) {
        // 只需满足s1中各个字母个数和s2中相同长度的子字符串各个字母个数一致即可
        int len1 = s1.length(), len2 = s2.length();
        // s2长度小于s1 肯定不满足
        if (len2 < len1) {
            return false;
        }

        final int cnt = 26;
        int[] a = new int[cnt], b = new int[cnt];

        // 初始化s1长度的两个字符串各个字母的数量
        for (int i = 0; i < len1; i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }

        // 刚好是s1的排列
        if (Arrays.equals(a, b)) {
            return true;
        }

        int left = 0, right = len1;
        // 依次比较每个s1长度的s2是否是s1的排列
        while (right < len2) {
            b[s2.charAt(left++) - 'a']--;
            b[s2.charAt(right++) - 'a']++;
            if (Arrays.equals(a, b)) {
                return true;
            }
        }

        return false;
    }
    // #endregion snippet
}
