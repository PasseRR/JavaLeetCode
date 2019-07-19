package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution79}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 13:46
 * @author xiehai
 */
class Solution79Spec extends Specification {
    Solution79 solution79 = new Solution79()

    @Unroll
    def "exist(#board, #word) = #result"() {
        expect:
        result == this.solution79.exist(board, word)

        where:
        board                    | word     || result
        [['a', 'a']] as char[][] | "aaa"    || false
        [['a']] as char[][]      | "a"      || true
        [
            ['A', 'B', 'C', 'E'],
            ['S', 'F', 'C', 'S'],
            ['A', 'D', 'E', 'E']
        ] as char[][]            | "ABCCED" || true
        [
            ['A', 'B', 'C', 'E'],
            ['S', 'F', 'C', 'S'],
            ['A', 'D', 'E', 'E']
        ] as char[][]            | "ABCB"   || false
        [
            ['A', 'B', 'C', 'E'],
            ['S', 'F', 'C', 'S'],
            ['A', 'D', 'E', 'E']
        ] as char[][]            | "SEE"    || true
        [
            ['A', 'B'],
            ['C', 'D']
        ] as char[][]            | "ABDC"   || true
        [
            ['a', 'b'],
            ['c', 'd']
        ] as char[][]            | "abdc"   || true
    }
}
