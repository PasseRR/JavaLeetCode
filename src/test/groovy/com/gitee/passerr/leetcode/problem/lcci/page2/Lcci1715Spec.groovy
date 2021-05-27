package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1715}单元测试
 * @date 2021/05/26 17:26
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1715Spec extends Specification {
    Lcci1715 lcci1715 = new Lcci1715()

    @Unroll
    def "longestWord(#words) = #result"() {
        expect:
        result == this.lcci1715.longestWord(words)

        where:
        words                                                                       || result
        ["ttaaaa", "pp", "tpa", "kpaqkt", "tktpqq", "aqppatp"] as String[]          || ""
        ["cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"] as String[] || "dogwalker"
        ["ttaaaa", "pp", "tpa", "kpaqkt", "tktpqq", "aqppatp"] as String[]          || ""
    }
}