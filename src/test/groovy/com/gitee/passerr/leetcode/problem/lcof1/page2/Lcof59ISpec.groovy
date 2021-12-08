package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof59I}单元测试
 * @date 2020/07/22 09:02
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof59ISpec extends Specification {
    Lcof59I lcof59I = new Lcof59I()

    @Unroll
    def "maxSlidingWindow(#nums, #k) = #result"() {
        expect:
        result == this.lcof59I.maxSlidingWindow(nums, k)

        where:
        nums                                | k || result
        [1, 3, -1, -3, 5, 3, 6, 7] as int[] | 3 || [3, 3, 5, 5, 6, 7] as int[]
    }
}