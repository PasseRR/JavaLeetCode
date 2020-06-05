package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0102Spec}单元测试
 * @date 2020/06/05 14:55
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0102Spec extends Specification {
    Lcci0102 lcci0102 = new Lcci0102()

    @Unroll
    def "CheckPermutation(#s1, #s2) = #result"() {
        expect:
        result == this.lcci0102.CheckPermutation(s1, s2)

        where:
        s1    | s2    || result
        "abc" | "cba" || true
        "abc" | "bad" || false
    }
}
