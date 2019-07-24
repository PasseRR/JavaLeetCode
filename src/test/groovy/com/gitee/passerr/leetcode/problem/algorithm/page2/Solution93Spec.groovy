package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution93}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/24 16:39
 * @author xiehai
 */
class Solution93Spec extends Specification {
    Solution93 solution93 = new Solution93()

    @Unroll
    def "restoreIpAddresses(#s) = #result"() {
        expect:
        result == this.solution93.restoreIpAddresses(s)

        where:
        s             || result
        "25525511135" || ["255.255.11.135", "255.255.111.35"]
        "0000"        || ["0.0.0.0"]
    }
}
