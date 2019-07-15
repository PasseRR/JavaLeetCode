package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution58}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/15 12:26
 * @author xiehai
 */
class Solution58Spec extends Specification {
    Solution58 solution58 = new Solution58()

    @Unroll
    def "lengthOfLastWord(#s) = #result"() {
        expect:
        result == this.solution58.lengthOfLastWord(s)

        where:
        s             || result
        "a "          || 1
        ""            || 0
        "Hello World" || 5
    }
}
