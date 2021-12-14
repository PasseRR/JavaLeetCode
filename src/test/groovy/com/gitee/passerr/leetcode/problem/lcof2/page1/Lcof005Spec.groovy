package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof005}单元测试
 * @date 2021/12/13 10:01
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof005Spec extends Specification {
    Lcof005 lcof005 = new Lcof005()

    @Unroll
    def "maxProduct(#words) = #result"() {
        expect:
        result == this.lcof005.maxProduct(words)

        where:
        words                                                       || result
        ["abcw", "baz", "foo", "bar", "fxyz", "abcdef"] as String[] || 16
        ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] as String[]    || 4
        ["a", "aa", "aaa", "aaaa"] as String[]                      || 0
    }
}