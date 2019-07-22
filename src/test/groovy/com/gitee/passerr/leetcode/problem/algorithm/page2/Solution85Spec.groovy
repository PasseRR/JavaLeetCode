package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution85}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/22 14:14
 * @author xiehai
 */
class Solution85Spec extends Specification {
    Solution85 solution85 = new Solution85()

    @Unroll
    def "maximalRectangle(#matrix) = #result"() {
        expect:
        result == this.solution85.maximalRectangle(matrix)

        where:
        matrix        || result
        [
            ["1", "0", "1", "0", "0"],
            ["1", "0", "1", "1", "1"],
            ["1", "1", "1", "1", "1"],
            ["1", "0", "0", "1", "0"]
        ] as char[][] || 6
    }
}
