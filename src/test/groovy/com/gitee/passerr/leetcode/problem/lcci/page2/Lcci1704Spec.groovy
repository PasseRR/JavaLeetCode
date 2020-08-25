package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1704}单元测试
 * @date 2020/08/25 17:21
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1704Spec extends Specification {
    Lcci1704 lcci1704 = new Lcci1704()

    @Unroll
    def "missingNumber(#nums) = #result"() {
        expect:
        result == this.lcci1704.missingNumber(nums)

        where:
        nums               || result
        [0, 3, 1] as int[] || 2
    }
}