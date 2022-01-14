package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification

/**
 * {@link Lcof041}单元测试
 * @date 2022/01/14 16:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof041Spec extends Specification {
    Lcof041 lcof041 = new Lcof041()

    def "MovingAverage"() {
        given:
        def mv = new MovingAverage(3)

        expect:
        mv.next(1) == 1
        mv.next(10) == 5.5D
        mv.next(3) == 4.666666666666667D
        mv.next(5) == 6
    }
}
