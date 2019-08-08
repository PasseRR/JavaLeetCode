package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * @author xiehai
 * @date 2019/08/08 17:39
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        int length = s.length();
        // 动态规划
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j]表示单词能到达j位置
                // 若单词中包含s.substring(j, i) 表示单词能到达i位置
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    // 找到一个单词满足到达j处即可
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[length];
    }
}
