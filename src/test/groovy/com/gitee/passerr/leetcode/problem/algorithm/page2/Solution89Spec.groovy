package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution89}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/23 09:35
 * @author xiehai
 */
class Solution89Spec extends Specification {
    Solution89 solution89 = new Solution89()

    @Unroll
    def "grayCode(#n) = #result"() {
        expect:
        result == this.solution89.grayCode(n)

        where:
        n || result
        2 || [0, 1, 3, 2]
        3 || [0, 1, 3, 2, 6, 7, 5, 4]
    }
}
