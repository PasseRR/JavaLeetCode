package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution26}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/04 13:42
 * @author xiehai
 */
class Solution26Spec extends Specification {
    Solution26 solution26 = new Solution26()

    @Unroll
    def "removeDuplicates(#input) = #result"() {
        expect:
        result == this.solution26.removeDuplicates(input)

        where:
        input                                   || result
        [] as int[]                             || 0
        [1] as int[]                            || 1
        [1, 1, 2] as int[]                      || 2
        [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] as int[] || 5
    }
}
