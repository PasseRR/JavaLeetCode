package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution125}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 13:46
 * @author xiehai
 */
class Solution125Spec extends Specification {
    Solution125 solution125 = new Solution125()

    @Unroll
    def "isPalindrome(#s) = #result"() {
        expect:
        result == this.solution125.isPalindrome(s)

        where:
        s                                || result
//        "121"                            || true
//        "111"                            || true
//        "1A1"                            || true
//        "A man, a plan, a canal: Panama" || true
//        "race a car"                     || false
        ".,"                             || true
    }
}
