package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.function.BiFunction;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>
 * 示例2:
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * <p>
 * 提示:
 * words的长度在[1, 1000000]之间
 * @author xiehai
 * @date 2020/08/10 09:28
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1004 {
    public int findString(String[] words, String s) {
        BiFunction<Integer, Integer, Integer> binarySearch = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                // 左右区间压缩
                while (left <= right && words[left].isEmpty()) {
                    left++;
                }
                while (right >= 0 && words[right].isEmpty()) {
                    right--;
                }

                // 未找到结果
                if (left > right) {
                    return -1;
                }

                // 中位压缩
                int mid = (left + right) >> 1;
                while (words[mid].isEmpty()) {
                    mid--;
                }

                int compare = words[mid].compareTo(s);
                return compare == 0 ? mid : (compare > 0 ? this.apply(left, mid - 1) : this.apply(mid + 1, right));
            }
        };

        return binarySearch.apply(0, words.length - 1);
    }
}
