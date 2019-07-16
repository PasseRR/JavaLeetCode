package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution69}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 16:01
 * @author xiehai
 */
class Solution69Spec extends Specification {
    Solution69 solution69 = new Solution69()

    @Unroll
    def "mySqrt(#x) = #result"() {
        expect:
        result == this.solution69.mySqrt(x)

        where:
        x || result
//        4 || 2
//        3 || 1
//        5 || 2
        8 || 2
    }
}
