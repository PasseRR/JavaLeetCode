package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification

/**
 * {@link Lcof042}单元测试
 * @date 2022/01/14 16:28
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof042Spec extends Specification {
    Lcof042 lcof042 = new Lcof042()

    def "RecentCounter"() {
        given:
        def counter = new RecentCounter()
        
        expect:
        counter.ping(1) == 1
        counter.ping(100) == 2
        counter.ping(3001) == 3
        counter.ping(3002) == 3
    }
}
