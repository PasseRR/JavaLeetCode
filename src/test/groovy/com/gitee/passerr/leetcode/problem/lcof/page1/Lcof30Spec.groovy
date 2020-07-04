package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification

/**
 * {@link Lcof30}单元测试
 * @date 2020/07/04 16:01
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof30Spec extends Specification {
    def "MinStack"() {
        given:
        MinStack stack = new MinStack()

        when:
        stack.push(-2)
        stack.push(0)
        stack.push(-3)

        then:
        stack.min() == -3

        when:
        stack.pop()
        then:
        stack.min() == -2
        stack.top() == 0
    }
}