package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1719}单元测试
 * @date 2021/06/10 13:45
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1719Spec extends Specification {
    Lcci1719 lcci1719 = new Lcci1719()

    @Unroll
    def "missingTwo(#nums) = #result"() {
        expect:
        result == this.lcci1719.missingTwo(nums)

        where:
        nums            || result
        [1] as int[]    || [2, 3] as int[]
        [1, 3] as int[] || [2, 4] as int[]
    }
}