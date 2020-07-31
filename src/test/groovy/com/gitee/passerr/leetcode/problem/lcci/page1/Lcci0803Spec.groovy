package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0803}单元测试
 * @date 2020/07/31 13:07
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0803Spec extends Specification {
    Lcci0803 lcci0803 = new Lcci0803()

    @Unroll
    def "findMagicIndex(#nums) = #result"() {
        expect:
        result == this.lcci0803.findMagicIndex(nums)

        where:
        nums                  || result
        [0, 2, 3, 4] as int[] || 0
        [1, 1, 1] as int[]    || 1
    }
}