package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1718}单元测试
 * @date 2021/05/28 18:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1718Spec extends Specification {
    Lcci1718 lcci1718 = new Lcci1718()

    @Unroll
    def "shortestSeq(#big, #small) = #result"() {
        expect:
        result == this.lcci1718.shortestSeq(big, small)

        where:
        big                                                          | small              || result
        [7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7] as int[] | [1, 5, 9] as int[] || [7, 10] as int[]
    }
}