package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0105}单元测试
 * @date 2020/06/05 15:50
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0105Spec extends Specification {
    Lcci0105 lcci0105 = new Lcci0105()

    @Unroll
    def "oneEditAway(#first, #second) == #result"() {
        expect:
        result == this.lcci0105.oneEditAway(first, second)

        where:
        first   | second || result
        "pale"  | "ple"  || true
        "pales" | "pal"  || false
    }
}