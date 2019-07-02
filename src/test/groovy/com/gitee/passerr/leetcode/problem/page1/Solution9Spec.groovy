package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution9}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 10:19
 * @author xiehai
 */
class Solution9Spec extends Specification {
    Solution9 solution9 = new Solution9()

    @Unroll
    def "isPalindrome(#input) = #result"() {
        expect:
        result == this.solution9.isPalindrome(input)

        where:
        input || result
        121   || true
        0     || true
        1     || true
        -1    || false
        10    || false
    }
}
