package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0508}单元测试
 * @date 2020/06/23 09:53
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0508Spec extends Specification {
    Lcci0508 lcci0508 = new Lcci0508()

    @Unroll
    def "drawLine(#length, #w, #x1, #x2, #y) = #result"() {
        expect:
        result == this.lcci0508.drawLine(length, w, x1, x2, y)

        where:
        length | w  | x1 | x2 | y || result
        1      | 32 | 30 | 31 | 0 || [3] as int[]
        3      | 96 | 0  | 95 | 0 || [-1, -1, -1] as int[]
    }
}