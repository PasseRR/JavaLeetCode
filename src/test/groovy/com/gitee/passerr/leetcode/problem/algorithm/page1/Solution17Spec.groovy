package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution17}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/03 09:58
 * @author xiehai
 */
class Solution17Spec extends Specification {
    Solution17 solution17 = new Solution17()

    @Unroll
    def "letterCombinations(#input) = #result"() {
        expect:
        result == this.solution17.letterCombinations(input)

        where:
        input || result
        "2"   || ["a", "b", "c"]
        "23"  || ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }
}
