package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0804}单元测试
 * @date 2020/07/31 13:10
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0804Spec extends Specification {
    Lcci0804 lcci0804 = new Lcci0804()

    @Unroll
    def "subsets(#nums) = #result"() {
        expect:
        result == this.lcci0804.subsets(nums)

        where:
        nums               || result
        [1, 2, 3] as int[] || [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }
}