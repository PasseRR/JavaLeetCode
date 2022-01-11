package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof038}单元测试
 * @date 2022/01/11 16:49
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof038Spec extends Specification {
    Lcof038 lcof038 = new Lcof038()

    @Unroll
    def "dailyTemperatures(#temperatures) = #result"() {
        expect:
        result == this.lcof038.dailyTemperatures(temperatures)

        where:
        temperatures                                       || result
        [73, 74, 75, 71, 69, 72, 76, 73] as int[]          || [1, 1, 4, 2, 1, 1, 0, 0] as int[]
        [30, 40, 50, 60] as int[]                          || [1, 1, 1, 0] as int[]
        [30, 60, 90] as int[]                              || [1, 1, 0] as int[]
    }
}
