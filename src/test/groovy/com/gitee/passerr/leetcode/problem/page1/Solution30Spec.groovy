package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution30}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/04 16:47
 * @author xiehai
 */
class Solution30Spec extends Specification {
    Solution30 solution30 = new Solution30()

    @Unroll
    def "findSubstring(#s, #words) = #result"() {
        expect:
        result == this.solution30.findSubstring(s, words)

        where:
        s                          | words                                        || result
        "barfoothefoobarman"       | ["foo", "bar"] as String[]                   || [0, 9]
        "wordgoodgoodgoodbestword" | ["word", "good", "best", "word"] as String[] || []
        "barfoofoobarthefoobarman" | ["bar", "foo", "the"] as String[]            || [6, 9, 12]
    }
}
