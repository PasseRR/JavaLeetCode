package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution97}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/25 10:24
 * @author xiehai
 */
class Solution97Spec extends Specification {
    Solution97 solution97 = new Solution97()

    @Unroll
    def "isInterleave(#s1, #s2, #s3) = #result"() {
        expect:
        result == this.solution97.isInterleave(s1, s2, s3)

        where:
        s1      | s2      | s3           || result
        "db"    | "b"     | "cbb"        || false
        ""      | "abc"   | "abc"        || true
        "aabcc" | "dbbca" | "aadbbcbcac" || true
        "aabcc" | "dbbca" | "aadbbbaccc" || false
    }
}
