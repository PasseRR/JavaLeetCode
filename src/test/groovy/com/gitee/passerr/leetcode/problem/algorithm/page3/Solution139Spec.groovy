package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution139}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/08 17:49
 * @author xiehai
 */
class Solution139Spec extends Specification {
    Solution139 solution139 = new Solution139()

    @Unroll
    def "wordBreak(#s, #wordDict) = #result"() {
        expect:
        result == this.solution139.wordBreak(s, wordDict)

        where:
        s               | wordDict                              || result
        "leetcode"      | ["leet", "code"]                      || true
        "applepenapple" | ["apple", "pen"]                      || true
        "catsandog"     | ["cats", "dog", "sand", "and", "cat"] || false
    }
}
