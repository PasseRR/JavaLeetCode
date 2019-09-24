package com.gitee.passerr.leetcode.contest.season.fall2019;

import java.util.function.BiFunction;

/**
 * @author xiehai1
 * @date 2019/09/24 21:33
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Solution2 {
    public int[] fraction(int[] cont) {
        int[] result = new int[2];
        int length = cont.length;
        if (length == 1) {
            return new int[]{cont[0], 1};
        }

        result[0] = 1;
        result[1] = cont[length - 1];
        for (int i = length - 2; i > 0; i--) {
            int temp = result[1];
            result[1] = cont[i] * result[1] + result[0];
            result[0] = temp;
        }

        result[0] += result[1] * cont[0];

        BiFunction<Integer, Integer, Integer> recursion = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a % b == 0 ? b : this.apply(b, a % b);
            }
        };
        int gcd = recursion.apply(result[0], result[1]);
        result[0] /= gcd;
        result[1] /= gcd;

        return result;
    }
}
