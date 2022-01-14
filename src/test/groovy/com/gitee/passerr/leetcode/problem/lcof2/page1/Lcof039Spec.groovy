package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof039}单元测试
 * @date 2022/01/11 18:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof039Spec extends Specification {
    Lcof039 lcof039 = new Lcof039()

    @Unroll
    def "largestRectangleArea(#heights) = #result"() {
        expect:
        result == this.lcof039.largestRectangleArea(heights)

        where:
        heights                     || result
        [1, 2, 3] as int[]          || 4
        [3] as int[]                || 3
        [2, 1, 5, 6, 2, 3] as int[] || 10
        [2, 1, 1, 6, 1, 3] as int[] || 6
        [2, 4] as int[]             || 4
    }
}
