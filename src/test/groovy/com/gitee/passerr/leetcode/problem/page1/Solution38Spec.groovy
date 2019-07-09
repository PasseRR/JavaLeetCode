package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution38}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/09 10:02
 * @author xiehai
 */
class Solution38Spec extends Specification {
    Solution38 solution38 = new Solution38()

    @Unroll
    def "countAndSay(#input) = #result"() {
        expect:
        result == this.solution38.countAndSay(input)

        where:
        input || result
        1     || "1"
        2     || "11"
        3     || "21"
        4     || "1211"
        5     || "111221"
        6     || "312211"
        7     || "13112221"
    }
}
