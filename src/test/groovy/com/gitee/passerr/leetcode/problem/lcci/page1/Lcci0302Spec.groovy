package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0302}单元测试
 * @date 2020/06/05 17:51
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0302Spec extends Specification {
    @Unroll
    def "min stack"() {
        given:
        def stack = new MinStack()

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