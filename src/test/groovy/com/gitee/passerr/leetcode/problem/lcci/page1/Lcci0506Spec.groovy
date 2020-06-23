package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0506}单元测试
 * @date 2020/06/23 09:47
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0506Spec extends Specification {
    Lcci0506 lcci0506 = new Lcci0506()

    @Unroll
    def "convertInteger(#A, #B) = #result"() {
        expect:
        result == this.lcci0506.convertInteger(A, B)

        where:
        A  | B  || result
        29 | 15 || 2
        1  | 2  || 2
    }
}