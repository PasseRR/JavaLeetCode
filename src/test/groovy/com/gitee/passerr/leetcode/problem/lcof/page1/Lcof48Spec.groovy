package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof48}单元测试
 * @date 2020/07/14 13:14
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof48Spec extends Specification {
    Lcof48 lcof48 = new Lcof48()

    @Unroll
    def "lengthOfLongestSubstring(#s) = #result"() {
        expect:
        result == this.lcof48.lengthOfLongestSubstring(s)

        where:
        s          || result
        "abcabcbb" || 3
        "bbbbb"    || 1
        "pwwkew"   || 3
    }
}