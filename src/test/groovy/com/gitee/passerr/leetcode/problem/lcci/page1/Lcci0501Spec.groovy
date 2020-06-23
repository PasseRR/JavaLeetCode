package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0501}单元测试
 * @date 2020/06/23 09:30
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0501Spec extends Specification {
    Lcci0501 lcci0501 = new Lcci0501()

    @Unroll
    def "insertBits(#N, #M, #i, #j) = #result"() {
        expect:
        result == this.lcci0501.insertBits(N, M, i, j)

        where:
        N    | M  | i | j || result
        1024 | 19 | 2 | 6 || 1100
    }
}