package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;

/**
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 * 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * <p>
 * 示例 2:
 * 输入: ["A","A"]
 * 输出: []
 * <p>
 * 提示：
 * array.length <= 100000
 * @author xiehai
 * @date 2020/08/25 17:48
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1705 {
    public String[] findLongestSubarray(String[] array) {
        int from = 0, to = 0;
        return Arrays.copyOfRange(array, from, to);
    }
}
