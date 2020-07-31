package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0802}单元测试
 * @date 2020/07/31 13:04
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0802Spec extends Specification {
    Lcci0802 lcci0802 = new Lcci0802()

    @Unroll
    def "pathWithObstacles(#grid) = #result"() {
        expect:
        result == this.lcci0802.pathWithObstacles(grid)

        where:
        grid         || result
        [
            [0, 0, 0],
            [0, 1, 0],
            [0, 0, 0]
        ] as int[][] || [[0, 0], [1, 0], [2, 0], [2, 1], [2, 2]]
    }
}