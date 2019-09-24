package com.gitee.passerr.leetcode.contest.season.fall2019;

/**
 * @author xiehai1
 * @date 2019/09/24 21:31
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Solution1 {
    public int game(int[] guess, int[] answer) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                result++;
            }
        }

        return result;
    }
}
