package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof12}单元测试
 * @date 2020/07/04 14:48
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof12Spec extends Specification {
    Lcof12 lcof12 = new Lcof12()

    @Unroll
    def "exist(#board, #word) = #result"() {
        expect:
        result == this.lcof12.exist(board, word)

        where:
        board         | word   || result
        [
            ["a", "b", "c", "e"],
            ["s", "f", "c", "s"],
            ["a", "d", "e", "e"]
        ] as char[][] | "bfce" || true
        [
            ["a", "b", "c", "e"],
            ["s", "f", "c", "s"],
            ["a", "d", "e", "e"]
        ] as char[][] | "abcd" || false
    }
}