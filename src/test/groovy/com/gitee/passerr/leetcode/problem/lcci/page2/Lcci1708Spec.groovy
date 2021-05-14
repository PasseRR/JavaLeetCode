package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1708}单元测试
 * @date 2021/05/14 12:18
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1708Spec extends Specification {
    Lcci1708 lcci1708 = new Lcci1708()

    @Unroll
    def "bestSeqAtIndex(#height, #weight) = #result"() {
        expect:
        result == this.lcci1708.bestSeqAtIndex(height, weight)

        where:
        height                                                                | weight                                                               || result
//        [65, 70, 56, 75, 60, 68] as int[]                                     | [100, 150, 90, 190, 95, 110] as int[]                                || 6
        [5401, 9628, 3367, 6600, 6983, 7853, 5715, 2654, 4453, 8619] as int[] | [3614, 1553, 2731, 7894, 8689, 182, 7632, 4465, 8932, 4304] as int[] || 5
    }
}