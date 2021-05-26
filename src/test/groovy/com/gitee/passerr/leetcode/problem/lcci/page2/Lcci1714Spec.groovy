package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1714}单元测试
 * @date 2021/05/26 17:17
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1714Spec extends Specification {
    Lcci1714 lcci1714 = new Lcci1714()

    @Unroll
    def "smallestK(#arr, #k) = #result"() {
        expect:
        result == this.lcci1714.smallestK(arr, k)

        where:
        arr                               | k || result
        [1, 3, 5, 7, 2, 4, 6, 8] as int[] | 4 || [1, 2, 3, 4] as int[]
    }
}