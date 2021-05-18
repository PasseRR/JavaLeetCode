package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1710}单元测试
 * @date 2021/05/17 18:06
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1710Spec extends Specification {
    Lcci1710 lcci1710 = new Lcci1710()

    @Unroll
    def "majorityElement(#nums) = #result"() {
        expect:
        result == this.lcci1710.majorityElement(nums)

        where:
        nums                                 || result
        [1, 2, 5, 9, 5, 9, 5, 5, 5] as int[] || 5
        [1, 2] as int[]                      || -1
        [2, 2, 1, 1, 1, 2, 2] as int[]       || 2
        [] as int[]                          || -1
        [1] as int[]                         || 1
    }
}