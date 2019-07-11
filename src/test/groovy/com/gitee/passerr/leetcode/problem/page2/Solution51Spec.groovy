package com.gitee.passerr.leetcode.problem.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution51}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/11 12:50
 * @author xiehai
 */
class Solution51Spec extends Specification {
    Solution51 solution51 = new Solution51()

    @Unroll
    def "solveNQueens(#n) = #result"() {
        expect:
        result == this.solution51.solveNQueens(n)

        where:
        n || result
        1 || [["Q"]]
        2 || []
        3 || []
        4 || [["..Q.", "Q...", "...Q", ".Q.."], [".Q..", "...Q", "Q...", "..Q."]]
    }
}
