package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0109}单元测试
 * @date 2020/06/05 16:26
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0109Spec extends Specification {
    Lcci0109 lcci0109 = new Lcci0109()

    @Unroll
    def "isFlipedString(#s1, #s2) = #result"() {
        expect:
        result == this.lcci0109.isFlipedString(s1, s2)

        where:
        s1            | s2            || result
        "waterbottle" | "erbottlewat" || true
        "aa"          | "aba"         || false
    }
}