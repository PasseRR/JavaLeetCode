package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0812}单元测试
 * @date 2020/07/31 17:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0812Spec extends Specification {
    Lcci0812 lcci0812 = new Lcci0812()

    @Unroll
    def "solveNQueens(#n) = #result"() {
        expect:
        result == this.lcci0812.solveNQueens(n)

        where:
        n || result
        1 || [["Q"]]
        2 || []
        3 || []
        4 || [[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]
    }
}