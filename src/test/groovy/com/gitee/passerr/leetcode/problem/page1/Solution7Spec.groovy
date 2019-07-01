package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution7}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/01 16:42
 * @author xiehai
 */
class Solution7Spec extends Specification {
    Solution7 solution7 = new Solution7()

    @Unroll
    def "reverse(#input) = #result"() {
        expect:
        result == this.solution7.reverse(input)
        where:
        input      || result
        -123       || -321
        1534236469 || 0
    }
}
