package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification

/**
 * {@link Solution155}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 15:19
 * @author xiehai
 */
class Solution155Spec extends Specification {
    Solution155 solution155 = new Solution155()

    def "min stack"() {
        given:
        MinStack stack = new MinStack()
        when:
        stack.push(-2)
        stack.push(0)
        stack.push(-3)
        then:
        stack.getMin() == -3

        when:
        stack.pop()
        then:
        stack.top() == 0
        stack.getMin() == -2
    }
}
