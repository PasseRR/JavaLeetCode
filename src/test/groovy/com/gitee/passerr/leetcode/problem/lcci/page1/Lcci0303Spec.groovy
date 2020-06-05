package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification

/**
 * {@link Lcci0303}单元测试
 * @date 2020/06/05 18:07
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0303Spec extends Specification {
    def "stack of plates"() {
        given:
        def stack = new StackOfPlates(1)

        when:
        stack.push(1)
        stack.push(2)
        then:
        stack.popAt(1) == 2
        stack.pop() == 1
        stack.pop() == -1
    }

    def "#23"() {
        given:
        def stack = new StackOfPlates(2)

        when:
        stack.push(1)
        stack.push(2)
        stack.push(3)
        then:
        stack.popAt(0) == 2
        stack.popAt(0) == 1
        stack.popAt(0) == 3
    }
}