package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0808}单元测试
 * @date 2020/07/31 13:20
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0808Spec extends Specification {
    Lcci0808 lcci0808 = new Lcci0808()

    @Unroll
    def "permutation(#s) = #result"() {
        expect:
        result == this.lcci0808.permutation(s)

        where:
        s     || result
        "qqe" || ["qqe", "qeq", "eqq"] as String[]
        "ab"  || ["ab", "ba"] as String[]
    }
}