package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof035}单元测试
 * @date 2022/01/11 09:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof035Spec extends Specification {
    Lcof035 lcof035 = new Lcof035()

    @Unroll
    def "findMinDifference(#timePoints) = #result"() {
        expect:
        result == this.lcof035.findMinDifference(timePoints)

        where:
        timePoints                  || result
        ["23:59", "00:00"]          || 1
        ["00:00", "23:59", "00:00"] || 0
    }
}
