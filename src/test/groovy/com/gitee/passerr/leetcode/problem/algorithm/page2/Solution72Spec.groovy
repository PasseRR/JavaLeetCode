package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution72}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/17 11:39
 * @author xiehai
 */
class Solution72Spec extends Specification {
    Solution72 solution72 = new Solution72()

    @Unroll
    def "minDistance(#word1, #word2) = #result"() {
        expect:
        result == this.solution72.minDistance(word1, word2)

        where:
        word1       | word2       || result
        ""          | "world"     || 5
        "world"     | ""          || 5
        "world"     | "world"     || 0
        "world"     | "wld"       || 2
        "horse"     | "ros"       || 3
        "intention" | "execution" || 5
    }
}
