package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution3}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/01 10:39
 * @author xiehai
 */
class Solution3Spec extends Specification {
    Solution3 solution3 = new Solution3()

    @Unroll
    def "lengthOfLongestSubstring(#input) = #result"() {
        expect:
        result == solution3.lengthOfLongestSubstring(input)

        where:
        input      || result
        "abcabcbb" || 3
        "bbbbb"    || 1
        "pwwkew"   || 3
        "abcdefg"  || 7
        "dvdf"     || 3
    }
}
