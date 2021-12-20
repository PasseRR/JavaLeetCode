package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification

/**
 * {@link Lcof013}单元测试
 * @date 2021/12/16 14:08
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof013Spec extends Specification {
    def "NumMatrix"() {
        given:
        def matrix = new NumMatrix(
            [
                [3, 0, 1, 4, 2],
                [5, 6, 3, 2, 1],
                [1, 2, 0, 1, 5],
                [4, 1, 0, 1, 7],
                [1, 0, 3, 0, 5]
            ] as int[][]
        )
        
        expect:
        matrix.sumRegion(2, 1, 4, 3) == 8
        matrix.sumRegion(1, 1, 2, 2) == 11
        matrix.sumRegion(1, 2, 2, 4) == 12
    }
}
