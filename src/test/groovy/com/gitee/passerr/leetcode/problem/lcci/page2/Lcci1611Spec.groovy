package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1611}单元测试
 * @date 2020/08/21 14:42
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1611Spec extends Specification {
    Lcci1611 lcci1611 = new Lcci1611()

    @Unroll
    def "divingBoard(#shorter, #longer, #k) = #result"() {
        expect:
        result == this.lcci1611.divingBoard(shorter, longer, k)

        where:
        shorter | longer | k || result
        1       | 1      | 0 || [] as int[]
        1       | 1      | 3 || [3] as int[]
        1       | 2      | 3 || [3, 4, 5, 6] as int[]
    }
}