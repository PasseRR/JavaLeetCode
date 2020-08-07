package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1001}单元测试
 * @date 2020/08/07 18:01
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1001Spec extends Specification {
    Lcci1001 lcci1001 = new Lcci1001()

    @Unroll
    def "merge(#a, #m, #b, #n)"() {
        when:
        this.lcci1001.merge(a, m, b, n)
        then:
        result == a

        where:
        a                        | m | b               | n || result
        [1, 2, 3, 0, 0] as int[] | 3 | [2, 4] as int[] | 2 || [1, 2, 2, 3, 4] as int[]
    }
}