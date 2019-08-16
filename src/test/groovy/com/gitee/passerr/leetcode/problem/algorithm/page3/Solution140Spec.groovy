package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution140}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/08 18:11
 * @author xiehai
 */
class Solution140Spec extends Specification {
    Solution140 solution140 = new Solution140()

    @Unroll
    def "wordBreak(#s, #wordDict) = #result"() {
        expect:
        result == this.solution140.wordBreak(s, wordDict)

        where:
        s                         | wordDict                                                            || result
        "catsanddog"              | ["cat", "cats", "and", "sand", "dog"]                               ||
        ["cat sand dog", "cats and dog"]
        "pineapplepenapple"       | ["apple", "pen", "applepen", "pine", "pineapple"]                   || [
            "pine apple pen apple",
            "pine applepen apple",
            "pineapple pen apple"
        ]
        "catsandog"               | ["cats", "dog", "sand", "and", "cat"]                               || []
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaa" |
        ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"] || []
    }
}
