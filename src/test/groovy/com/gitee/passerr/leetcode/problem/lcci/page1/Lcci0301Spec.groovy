package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification

/**
 * {@link Lcci0301}单元测试
 * @date 2020/06/05 17:44
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0301Spec extends Specification {
    def "triple in one"() {
        given:
        def stack = new TripleInOne(1)
        when:
        stack.push(0, 1)
        stack.push(0, 2)

        then:
        stack.pop(0) == 1
        stack.pop(0) == -1
        stack.pop(0) == -1
        stack.isEmpty(0)

        when:
        stack = new TripleInOne(2)
        stack.push(0, 1)
        stack.push(0, 2)
        stack.push(0, 3)

        then:
        stack.pop(0) == 2
        stack.pop(0) == 1
        stack.pop(0) == -1
        stack.peek(0) == -1
    }
}