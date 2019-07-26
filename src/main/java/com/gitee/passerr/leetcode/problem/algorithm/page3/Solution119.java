package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * @author xiehai
 * @date 2019/07/26 11:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex > 0) {
            result.add(1);
        }
        for (int i = 2; i <= rowIndex; i++) {
            int previous = 1;
            for (int j = 1; j < i; j++) {
                int temp = result.get(j);
                result.set(j, temp + previous);
                previous = temp;
            }
            result.add(1);
        }

        return result;
    }
}
