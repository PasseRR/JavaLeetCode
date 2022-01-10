package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个字符串数组 strs ，将变位词组合在一起。 可以按任意顺序返回结果列表。
 * <p>
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 提示：
 * 1 <= strs.length <= 10<sup>4</sup>
 * 0 <= strs[i].length <= 100
 * strs[i]仅包含小写字母
 * <p>
 * 注意：本题与主站 49题相同：https://leetcode-cn.com/problems/group-anagrams/
 * @author xiehai
 * @date 2022/01/10 10:49
 */
public class Lcof033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return
            new ArrayList<>(
                Arrays.stream(strs)
                    .collect(
                        // 排序字符串 并按照排序字符串分组
                        Collectors.groupingBy(it -> {
                            char[] chars = it.toCharArray();
                            Arrays.sort(chars);

                            return new String(chars);
                        })
                    )
                    .values()
            );
    }
}
