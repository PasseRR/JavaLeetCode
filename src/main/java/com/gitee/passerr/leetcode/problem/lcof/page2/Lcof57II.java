package com.gitee.passerr.leetcode.problem.lcof.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * 1 <= target <= 10^5
 * @author xiehai
 * @date 2020/07/21 17:14
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof57II {
    public int[][] findContinuousSequence(int target) {
        // 若果两数之和为target 根据题意 假如连续的两个数字为x 那么 x + (x+1) = 2x+1 = target
        // 若三数之和为target 那么 x + (x+1) + (x+2) = 3x + 3 = target
        // 四数之和 那么 x + (x+1) + (x+2) + (x+3) = 4x + 6 = target
        // N数之和 那么 x + (x + 1) ... + (x+n-1) = n*(x + (x+n-1))/2 = target
        List<int[]> result = new ArrayList<>();
        // 连续数量
        int count = 1;
        while (target > 0 && count <= target / 2) {
            target -= count++;
            if (target % count == 0) {
                int start = target / count;
                result.add(
                    IntStream.range(0, count)
                        .map(it -> start + it)
                        .toArray()
                );
            }
        }

        Collections.reverse(result);

        return result.toArray(new int[0][0]);
    }
}
