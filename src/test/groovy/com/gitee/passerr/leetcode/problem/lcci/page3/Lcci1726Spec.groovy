package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1726}单元测试
 * @date 2021/06/24 17:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1726Spec extends Specification {
    Lcci1726 lcci1726 = new Lcci1726()

    @Unroll
    def "computeSimilarities(#docs) = #result"() {
        expect:
        result == this.lcci1726.computeSimilarities(docs)

        where:
        docs         || result
        [
            [14, 15, 100, 9, 3],
            [32, 1, 9, 3, 5],
            [15, 29, 2, 6, 8, 7],
            [7, 10]
        ] as int[][] || [
            "0,1: 0.2500",
            "0,2: 0.1000",
            "2,3: 0.1429"
        ]
    }
}