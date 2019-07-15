package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution60}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/15 14:49
 * @author xiehai
 */
class Solution60Spec extends Specification {
    Solution60 solution60 = new Solution60()

    @Unroll
    def "getPermutation(#n, #k) = #result"() {
        expect:
        result == this.solution60.getPermutation(n, k)

        where:
        n | k || result
        1 | 1 || "1"
        2 | 2 || "21"
        3 | 3 || "213"
        3 | 2 || "132"
        4 | 9 || "2314"
    }
}
