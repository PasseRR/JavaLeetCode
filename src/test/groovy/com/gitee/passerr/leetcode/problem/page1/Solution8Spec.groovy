package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution8}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/01 17:21
 * @author xiehai
 */
class Solution8Spec extends Specification {
    Solution8 solution8 = new Solution8()

    @Unroll
    def "myAtoi(#input) = #result"() {
        expect:
        result == this.solution8.myAtoi(input)

        where:
        input             || result
        "42"              || 42
        "   -42"          || -42
        "4193 with words" || 4193
        "words and 987"   || 0
        "-91283472332"    || -2147483648
        ""                || 0
        "-"               || 0
        "3.1343214"       || 3
        "3.1.34"          || 3
    }
}
