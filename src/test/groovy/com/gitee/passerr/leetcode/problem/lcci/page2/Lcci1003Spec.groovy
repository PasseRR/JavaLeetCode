package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1003}单元测试
 * @date 2020/08/10 09:12
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1003Spec extends Specification {
    Lcci1003 lcci1003 = new Lcci1003()

    @Unroll
    def "search(#arr, #target)"() {
        expect:
        result == this.lcci1003.search(arr, target)

        where:
        arr                                                  | target || result
        [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14] as int[] | 5      || 8
        [5, 5, 5, 1, 2, 3, 4, 5] as int[]                    | 5      || 0
    }
}