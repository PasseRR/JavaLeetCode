package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @author xiehai
 * @date 2019/07/10 20:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution49 {
    // #region snippet
    public List<List<String>> groupAnagrams(String[] strs) {
        // key为字符串排序后 value为遍历字符串
        Map<String, List<String>> result = new HashMap<>(8);
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // 通过相同的key判断是否是异位字符串
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }
    // #endregion snippet
}
