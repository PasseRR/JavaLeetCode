package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1624}单元测试
 * @date 2021/04/16 13:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1624Spec extends Specification {
    Lcci1624 lcci1624 = new Lcci1624()

    @Unroll
    def "pairSums(#nums, #target) = #result"() {
        expect:
        this.lcci1624.pairSums(nums, target) == result

        where:
        nums                  | target || result
        [1, 2, 3] as int[]    | 6      || []
        [5, 6, 5, 6] as int[] | 11     || [[5, 6], [5, 6]]
    }
}