package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * <p>
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * @author xiehai
 * @date 2019/07/12 16:16
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution57 {
    // #region snippet
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        boolean inserted = false;
        for (int[] interval : intervals) {
            if (!inserted) {
                // 找到非交叉区间 插入區間
                if (newInterval[1] < interval[0]) {
                    result.add(newInterval);
                    inserted = true;
                    result.add(interval);
                } else if (Math.max(interval[0], newInterval[0]) <= Math.min(interval[1], newInterval[1])) {
                    // 存在交叉
                    newInterval[0] = Math.min(interval[0], newInterval[0]);
                    newInterval[1] = Math.max(interval[1], newInterval[1]);
                } else {
                    // 较小的区间 直接插入
                    result.add(interval);
                }
            } else {
                // 已经将新区间插入 其他区间依次插入
                result.add(interval);
            }
        }

        // 若新区间是最大区间
        if (!inserted) {
            result.add(newInterval);
        }

        return result.toArray(new int[0][]);
    }
    // #endregion snippet
}
