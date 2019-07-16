package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.problem.algorithm.page2.Solution67
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution67}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 13:42
 * @author xiehai
 */
class Solution67Spec extends Specification {
    Solution67 solution67 = new Solution67()

    @Unroll
    def "addBinary(#a, #b) = #result"() {
        expect:
        result == this.solution67.addBinary(a, b)

        where:
        a      | b      || result
        ""     | "1"    || "1"
        "1"    | ""     || "1"
        "0"    | "1"    || "1"
        "11"   | "1"    || "100"
        "1010" | "1011" || "10101"
    }
}
