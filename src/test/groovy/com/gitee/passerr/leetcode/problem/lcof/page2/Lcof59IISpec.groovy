package com.gitee.passerr.leetcode.problem.lcof.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof59II}单元测试
 * @date 2020/07/22 09:06
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof59IISpec extends Specification {
    @Unroll
    def "MaxQueue"() {
        given:
        MaxQueue queue = new MaxQueue()

        when:
        queue.push_back(1)
        queue.push_back(2)
        then:
        queue.max_value() == 2
        queue.pop_front() == 1
        queue.max_value() == 2
    }
}