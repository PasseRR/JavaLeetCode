package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * |[
 * |  ["ate","eat","tea"],
 * |  ["nat","tan"],
 * |  ["bat"]
 * |]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author xiehai1
 * @date 2020/08/09 16:41
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 哈希缓存
        Map<String, List<String>> cache = new HashMap<>();

        for (String str : strs) {
            // 按照字母排序
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            cache.computeIfAbsent(new String(letters), it -> new ArrayList<>())
                .add(str);
        }

        return new ArrayList<>(cache.values());
    }
}
