package com.gitee.passerr.leetcode.problem.algorithm.page5

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution212}单元测试
 * @date 2021/07/13 14:16
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution212Spec extends Specification {
    Solution212 solution212 = new Solution212()

    @Unroll
    def "findWords(#board, #words) = #result"() {
        expect:
        result == this.solution212.findWords(board, words)

        where:
        board                    | words               || result
        [['a', 'a']] as char[][] | ["aaa"] as String[] || []
        [['a']] as char[][]      | ["a"] as String[]   || ["a"]
        [
            ['o', 'a', 'a', 'n'],
            ['e', 't', 'a', 'e'],
            ['i', 'h', 'k', 'r'],
            ['i', 'f', 'l', 'v']
        ] as char[][]            | [
            "oath", "pea", "eat", "rain"
        ] as String[]                                  || ["oath", "eat"]
        [
            ['o', 'a', 'a', 'n'],
            ['e', 't', 'a', 'e'],
            ['i', 'h', 'k', 'r'],
            ['i', 'f', 'l', 'v']
        ] as char[][]            | [
            "oath", "pea", "eat", "rain", "hklf", "hf"
        ] as String[]                                  || ["oath", "eat", "hklf", "hf"]
    }
}