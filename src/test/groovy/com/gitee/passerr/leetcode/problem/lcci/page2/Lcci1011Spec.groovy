package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1011}单元测试
 * @date 2020/08/10 15:37
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1011Spec extends Specification {
    Lcci1011 lcci1011 = new Lcci1011()

    @Unroll
    def "wiggleSort(#nums)"() {
        when:
        this.lcci1011.wiggleSort(nums)
        then:
        result == nums

        where:
        nums                        || result
        [3, 5, 2, 1, 6, 4] as int[] || [5, 2, 3, 1, 6, 4] as int[]
    }
}