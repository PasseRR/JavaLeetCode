package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof006}单元测试
 * @date 2021/12/13 10:42
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof006Spec extends Specification {
    Lcof006 lcof006 = new Lcof006()

    @Unroll
    def "twoSum(#numbers, #target) = #result"() {
        expect:
        result == this.lcof006.twoSum(numbers, target)


        where:
        numbers                   | target || result
        [1, 2, 4, 6, 10] as int[] | 8      || [1, 3] as int[]
        [2, 3, 4] as int[]        | 6      || [0, 2] as int[]
        [-1, 0] as int[]          | -1     || [0, 1] as int[]
    }
}