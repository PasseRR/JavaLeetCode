package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution13}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 15:32
 * @author xiehai
 */
class Solution13Spec extends Specification {
    Solution13 solution13 = new Solution13()

    @Unroll
    def "romanToInt(#input) = #result"() {
        expect:
        result == this.solution13.romanToInt(input)

        where:
        input     || result
        "M"       || 1000
        "III"     || 3
        "IV"      || 4
        "LVIII"   || 58
        "MCMXCIV" || 1994
    }
}
