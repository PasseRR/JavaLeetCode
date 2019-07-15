package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution43}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/09 17:38
 * @author xiehai
 */
class Solution43Spec extends Specification {
    Solution43 solution43 = new Solution43()

    @Unroll
    def "multiply(#num1, #num2) = #result"() {
        expect:
        result == this.solution43.multiply(num1, num2)

        where:
        num1      | num2  || result
        "123"     | "456" || "56088"
        "20"      | "30"  || "600"
        "2"       | "1"   || "2"
        "3143214" | "0"   || "0"
    }
}
