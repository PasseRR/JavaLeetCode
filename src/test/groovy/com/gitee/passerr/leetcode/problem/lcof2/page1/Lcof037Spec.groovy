package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof037}单元测试
 * @date 2022/01/11 09:48
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof037Spec extends Specification {
    Lcof037 lcof037 = new Lcof037()

    @Unroll
    def "asteroidCollision(#asteroids) = #result"() {
        expect:
        result == this.lcof037.asteroidCollision(asteroids)

        where:
        asteroids                || result
        [1, -1, -2, -2] as int[] || [-2, -2] as int[]
        [5, 10, -5] as int[]     || [5, 10] as int[]
        [8, -8] as int[]         || [] as int[]
        [10, 2, -5] as int[]     || [10] as int[]
        [-2, -1, 1, 2] as int[]  || [-2, -1, 1, 2] as int[]
    }
}
