package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1620}单元测试
 * @date 2021/03/23 10:15
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1620Spec extends Specification {
    Lcci1620 lcci1620 = new Lcci1620()

    @Unroll
    def "getValidT9Words(#num, #words) = #result"() {
        expect:
        result == this.lcci1620.getValidT9Words(num, words)

        where:
        num    | words                            || result
        "8733" | ["tree", "used"] as String[]     || ["tree", "used"]
        "2"    | ["a", "b", "c", "d"] as String[] || ["a", "b", "c"]
    }
}