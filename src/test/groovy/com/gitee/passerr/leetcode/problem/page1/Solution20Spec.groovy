package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution20}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/03 14:45
 * @author xiehai
 */
class Solution20Spec extends Specification {
    Solution20 solution20 = new Solution20()

    @Unroll
    def "isValid(#input) = #result"() {
        expect:
        result == this.solution20.isValid(input)

        where:
        input    || result
        "()"     || true
        "(("     || false
        ")("     || false
        "(){}[]" || true
        "(]"     || false
        "{()}"   || true
    }
}
