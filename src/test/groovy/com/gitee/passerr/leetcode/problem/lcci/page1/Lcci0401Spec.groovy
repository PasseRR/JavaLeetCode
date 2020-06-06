package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0401}单元测试
 * @date 2020/06/06 14:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0401Spec extends Specification {
    Lcci0401 lcci0401 = new Lcci0401()

    @Unroll
    def "findWhetherExistsPath(#n, #graph, #start, #target) = #result"() {
        expect:
        result == this.lcci0401.findWhetherExistsPath(n, graph, start, target)

        where:
        n | graph                                       | start | target || result
        3 | [[0, 1], [0, 2], [1, 2], [1, 2]] as int[][] | 0     | 2       | true
    }
}