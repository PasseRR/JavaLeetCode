package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1716}单元测试
 * @date 2021/05/27 15:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1716Spec extends Specification {
    Lcci1716 lcci1716 = new Lcci1716()

    @Unroll
    def "massage(#nums) = #result"() {
        expect:
        result == this.lcci1716.massage(nums)

        where:
        nums                              || result
        [] as int[]                       || 0
        [1, 2, 3, 1] as int[]             || 4
        [2, 7, 9, 3, 1] as int[]          || 12
        [2, 1, 4, 5, 3, 1, 1, 3] as int[] || 12
    }
}