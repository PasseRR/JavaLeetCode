package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1601}单元测试
 * @date 2020/08/10 15:59
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1601Spec extends Specification {
    Lcci1601 lcci1601 = new Lcci1601()

    @Unroll
    def "swapNumbers(#nums) = #result"() {
        expect:
        result == this.lcci1601.swapNumbers(nums)

        where:
        nums            || result
        [1, 2] as int[] || [2, 1] as int[]
        [1, 0] as int[] || [0, 1] as int[]
    }
}