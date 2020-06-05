package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification

/**
 * {@link Lcci0304}单元测试
 * @date 2020/06/05 19:10
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0304Spec extends Specification {
    def "my queue"() {
        given:
        def queue = new MyQueue()

        when:
        queue.push(1)
        queue.push(2)
        then:
        queue.peek() == 1
        queue.pop() == 1
        !queue.empty()
    }
}