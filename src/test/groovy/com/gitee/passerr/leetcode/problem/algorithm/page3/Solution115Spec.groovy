package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution115}单元测试
 * @date 2021/03/08 16:39
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution115Spec extends Specification {
    Solution115 solution115 = new Solution115()

    @Unroll
    def "numDistinct(#s, #t) = #result"() {
        expect:
        this.solution115.numDistinct(s, t) == result

        where:
        s         | t        || result
        "rabbbit" | "rabbit" || 3
        "babgbag" | "bag"    || 5
    }
}