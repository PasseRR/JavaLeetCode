package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1604}单元测试
 * @date 2020/08/14 14:17
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1604Spec extends Specification {
    Lcci1604 lcci1604 = new Lcci1604()

    @Unroll
    def "tictactoe(#board) = #result"() {
        expect:
        result == this.lcci1604.tictactoe(board)

        where:
        board                             || result
        ["OX ", "OX ", "O  "] as String[] || "O"
    }
}