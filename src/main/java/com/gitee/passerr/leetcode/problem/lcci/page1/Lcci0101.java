package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.HashSet;
import java.util.Set;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * @author xiehai
 * @date 2020/06/05 14:53
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0101 {
    // #region snippet
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }

        return true;
    }
    // #endregion snippet
}
