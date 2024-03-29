package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * <p>
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * @author xiehai
 * @date 2020/06/05 15:44
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0104 {
    // #region snippet
    public boolean canPermutePalindrome(String s) {
        // ascii码表 单词中不一定都是字母
        int[] cache = new int[128];
        // 记录字符出现次数
        for (char c : s.toCharArray()) {
            cache[c] ++;
        }

        // 满足回文条件 相同字符都为偶数个或有且仅有一个字符总数为奇数
        int max = 1;
        for (int count : cache) {
            // 只允许最多一个总数为奇数的字符
            if (count % 2 == 1) {
                max--;
            }

            if (max < 0) {
                return false;
            }
        }

        return true;
    }
    // #endregion snippet
}
