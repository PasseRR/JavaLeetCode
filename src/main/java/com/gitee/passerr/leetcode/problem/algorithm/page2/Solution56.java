package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @author xiehai
 * @date 2019/07/12 15:04
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        // 排序數組 先按照开区间升序排序 再按照闭区间升序排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < length) {
            int[] temp = intervals[i];
            // 前一个闭区间大于等于后一个开区间
            while (++i < length && intervals[i][0] <= temp[1]) {
                // 后一个闭区间大于前一个闭区间 替换闭区间
                if (temp[1] < intervals[i][1]) {
                    temp[1] = intervals[i][1];
                }
            }
            result.add(temp);
        }

        return result.toArray(new int[0][]);
    }
}
