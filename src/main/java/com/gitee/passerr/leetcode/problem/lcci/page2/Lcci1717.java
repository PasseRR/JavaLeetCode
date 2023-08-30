package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。
 * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * <p>
 * 示例：
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * <p>
 * 提示：
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 * @author xiehai
 * @date 2021/05/28 11:09
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1717 {
    // #region snippet
    public int[][] multiSearch(String big, String[] smalls) {
        int lenBig = big.length(), lenSmall = smalls.length;
        // 字符前缀缓存
        Map<Character, Set<Integer>> cache = new HashMap<>(26);
        for (int i = 0; i < lenBig; i++) {
            cache.merge(big.charAt(i), new HashSet<>(Collections.singleton(i)), (o, n) -> {
                o.addAll(n);
                return o;
            });
        }

        Function<String, int[]> getPositions = s -> {
            Set<Integer> indices;
            // 字符串为空或者不存在大字符串中不存在以短字符串开头的
            if (s.isEmpty() || (indices = cache.getOrDefault(s.charAt(0), new HashSet<>())).isEmpty()) {
                return new int[0];
            }

            int sLen = s.length();
            return
                indices.stream()
                    // 是否存在大字符串中
                    .filter(it -> lenBig - it >= sLen && big.substring(it, it + sLen).equals(s))
                    .mapToInt(Integer::intValue)
                    .sorted()
                    .toArray();
        };

        // 按照小单词依次遍历
        int[][] result = new int[lenSmall][];
        for (int i = 0; i < lenSmall; i++) {
            result[i] = getPositions.apply(smalls[i]);
        }
        return result;
    }
    // #endregion snippet
}
