package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1619}单元测试
 * @date 2021/03/23 09:27
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1619Spec extends Specification {
    Lcci1619 lcci1619 = new Lcci1619()

    @Unroll
    def "pondSizes(#land) = #result"() {
        expect:
        result == this.lcci1619.pondSizes(land)

        where:
        land         || result
        [
            [0, 2, 1, 0],
            [0, 1, 0, 1],
            [1, 1, 0, 1],
            [0, 1, 0, 1]
        ] as int[][] || [1, 2, 4] as int[]
    }
}