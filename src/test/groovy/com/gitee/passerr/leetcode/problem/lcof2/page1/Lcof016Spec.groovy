package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof016}单元测试
 * @date 2021/12/17 16:30
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof016Spec extends Specification {
    Lcof016 lcof016 = new Lcof016()

    @Unroll
    def "lengthOfLongestSubstring(#s) = #result"() {
        expect:
        result == this.lcof016.lengthOfLongestSubstring(s)

        where:
        s          || result
        "abcabcbb" || 3
        "bbbbb"    || 1
        "pwwkew"   || 3
    }
}
