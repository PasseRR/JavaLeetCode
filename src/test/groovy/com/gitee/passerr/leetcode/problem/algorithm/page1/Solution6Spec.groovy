package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution6}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/01 15:31
 * @author xiehai
 */
class Solution6Spec extends Specification {
    Solution6 solution6 = new Solution6()

    @Unroll
    def "convert(#s, #numRows) = #result"() {
        expect:
        result == this.solution6.convert(s, numRows)

        where:
        s                  | numRows || result
        "LEETCODEISHIRING" | 3       || "LCIRETOESIIGEDHN"
        "LEETCODEISHIRING" | 4       || "LDREOEIIECIHNTSG"
        "ABCD"             | 2       || "ACBD"
        "A"                | 1       || "A"
        "ABCD"             | 1       || "ABCD"
    }
}
