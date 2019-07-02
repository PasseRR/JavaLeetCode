package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution14}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 16:02
 * @author xiehai
 */
class Solution14Spec extends Specification {
    Solution14 solution14 = new Solution14()

    @Unroll
    def "longestCommonPrefix(#input) = #result"() {
        expect:
        result == this.solution14.longestCommonPrefix(input)

        where:
        input                                    || result
        ["flower", "flow", "flight"] as String[] || "fl"
        ["dog", "racecar", "car"] as String[]    || ""
        [] as String[]                           || ""
        [""] as String[]                         || ""
        ["abc"] as String[]                      || "abc"
        ["c", "c"] as String[]                   || "c"
    }
}
