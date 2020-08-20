package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1608}单元测试
 * @date 2020/08/17 16:34
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1608Spec extends Specification {
    Lcci1608 lcci1608 = new Lcci1608()

    @Unroll
    def "numberToWords(#num) = #result"() {
        expect:
        result == this.lcci1608.numberToWords(num)

        where:
        num   || result
        1     || "One"
        123   || "One Hundred Twenty Three"
        12345 || "Twelve Thousand Three Hundred Forty Five"
    }
}