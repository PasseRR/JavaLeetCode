package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution65}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 11:52
 * @author xiehai
 */
class Solution65Spec extends Specification {
    Solution65 solution65 = new Solution65()

    @Unroll
    def "isNumber(#s) = #result"() {
        expect:
        result == this.solution65.isNumber(s)

        where:
        s          || result
        "0"        || true
        " 0.1"     || true
        "abc"      || false
        "1 a"      || false
        "2e10"     || true
        "-90e3"    || true
        " 1e"      || false
        "e3"       || false
        "6e-1"     || true
        "99e2.5"   || false
        "53.5e93"  || true
        "--6"      || false
        "-+3"      || false
        "95a54e43" || false
    }
}
