package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * @author xiehai
 * @date 2019/07/26 11:14
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            result.add(Collections.singletonList(1));
        }
        if (numRows > 1) {
            result.add(Arrays.asList(1, 1));
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
            }
            result.add(row);
        }

        return result;
    }
}
