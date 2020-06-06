package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification

/**
 * {@link Lcci0305}单元测试
 * @date 2020/06/06 11:24
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0305Spec extends Specification {
    def "sorted stack"() {
        given:
        def stack = new SortedStack()

        when:
        stack.push(1)
        stack.push(2)
        then:
        stack.peek() == 1

        when:
        stack.pop()
        then:
        stack.peek() == 2
    }
}