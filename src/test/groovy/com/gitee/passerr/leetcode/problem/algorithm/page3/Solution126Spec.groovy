package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution126}单元测试
 * @date 2021/07/19 15:53
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution126Spec extends Specification {
    Solution126 solution126 = new Solution126()

    @Unroll
    def "findLadders(#beginWord, #endWord, #wordList) = #result"() {
        expect:
        result == this.solution126.findLadders(beginWord, endWord, wordList)

        where:
        beginWord | endWord | wordList                                   || result
        "hit"     | "cog"   | ["hot", "dot", "dog", "lot", "log", "cog"] || [["hit", "hot", "lot", "log", "cog"], ["hit", "hot", "dot", "dog", "cog"]]
    }
}