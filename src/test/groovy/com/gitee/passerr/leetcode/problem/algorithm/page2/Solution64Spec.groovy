package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution64}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 11:44
 * @author xiehai
 */
class Solution64Spec extends Specification {
    Solution64 solution64 = new Solution64()

    @Unroll
    def "minPathSum(#grid) = #result"() {
        expect:
        result == this.solution64.minPathSum(grid)

        where:
        grid         || result
        [
            [1, 3, 1],
            [1, 5, 1],
            [4, 2, 1]
        ] as int[][] || 7
    }
}
