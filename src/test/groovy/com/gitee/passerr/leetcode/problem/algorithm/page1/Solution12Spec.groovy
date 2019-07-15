package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution12}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 15:12
 * @author xiehai
 */
class Solution12Spec extends Specification {
    Solution12 solution12 = new Solution12()

    @Unroll
    def "intToRoman(#input) = #result"() {
        expect:
        result == this.solution12.intToRoman(input)

        where:
        input || result
        1000  || "M"
        3     || "III"
        4     || "IV"
        58    || "LVIII"
        1994  || "MCMXCIV"
    }
}
