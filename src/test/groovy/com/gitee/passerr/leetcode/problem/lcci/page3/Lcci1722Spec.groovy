package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1722}单元测试
 * @date 2021/06/16 17:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1722Spec extends Specification {
    Lcci1722 lcci1722 = new Lcci1722()

    @Unroll
    def "findLadders(#beginWord, #endWord, #wordList) = #result"() {
        expect:
        result == this.lcci1722.findLadders(beginWord, endWord, wordList)

        where:
        beginWord | endWord | wordList                                         || result
        "hit"     | "cog"   | ["hot", "dot", "dog", "lot", "log", "cog"]       || ["hit", "hot", "lot", "log", "cog"]
        "lost"    | "miss"  | ["most", "mist", "miss", "lost", "fist", "fish"] || ["lost", "most", "mist", "miss"]
    }
}