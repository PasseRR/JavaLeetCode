package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1616}单元测试
 * @date 2020/09/01 16:36
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1616Spec extends Specification {
    Lcci1616 lcci1616 = new Lcci1616()

    @Unroll
    def "subSort(#array) = #result"() {
        expect:
        result == this.lcci1616.subSort(array)

        where:
        array                                                  || result
        [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19] as int[] || [3, 9] as int[]
    }
}