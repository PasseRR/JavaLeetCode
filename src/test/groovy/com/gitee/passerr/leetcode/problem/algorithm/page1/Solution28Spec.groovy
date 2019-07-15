package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution28}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/04 15:11
 * @author xiehai
 */
class Solution28Spec extends Specification {
    Solution28 solution28 = new Solution28()

    @Unroll
    def "strStr(#haystack, #needle) = #result"() {
        expect:
        result == this.solution28.strStr(haystack, needle)

        where:
        haystack | needle || result
        "hello"  | "ll"   || 2
        "aaaaa"  | "ab"   || -1
        "a"      | "a"    || 0
        "aaab"   | "ab"   || 2
    }
}
