package com.gitee.passerr.leetcode.problem.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution52}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/11 15:39
 * @author xiehai
 */
class Solution52Spec extends Specification {
    Solution52 solution52 = new Solution52()

    @Unroll
    def "totalNQueens(#n) = #result"() {
        expect:
        result == this.solution52.totalNQueens(n)

        where:
        n || result
        1 || 1
        2 || 0
        3 || 0
        4 || 2
    }
}
