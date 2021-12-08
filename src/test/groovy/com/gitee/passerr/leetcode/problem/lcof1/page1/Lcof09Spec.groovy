package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification

/**
 * {@link Lcof09}单元测试
 * @date 2020/07/04 14:36
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof09Spec extends Specification {
    def "CQueue"() {
        given:
        CQueue queue = new CQueue()

        when:
        queue.appendTail(3)
        then:
        3 == queue.deleteHead()
        -1 == queue.deleteHead()
    }
}