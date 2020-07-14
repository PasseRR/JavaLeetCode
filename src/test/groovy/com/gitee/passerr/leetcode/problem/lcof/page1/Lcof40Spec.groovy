package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof40}单元测试
 * @date 2020/07/14 12:56
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof40Spec extends Specification {
    Lcof40 lcof40 = new Lcof40()

    @Unroll
    def "getLeastNumbers(#arr, #k) = #result"() {
        expect:
        result == this.lcof40.getLeastNumbers(arr, k)

        where:
        arr                   | k || result
        [3, 2, 1] as int[]    | 2 || [1, 2] as int[]
        [3, 2, 1, 4] as int[] | 3 || [1, 2, 3] as int[]
    }
}