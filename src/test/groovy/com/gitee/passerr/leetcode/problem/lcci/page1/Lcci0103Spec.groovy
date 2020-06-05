package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0103}单元测试
 * @date 2020/06/05 15:41
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0103Spec extends Specification {
    Lcci0103 lcci0103 = new Lcci0103()

    @Unroll
    def "replaceSpaces(#s, #length) = #result"() {
        expect:
        result == this.lcci0103.replaceSpaces(s, length)

        where:
        s                   | length || result
        "Mr John Smith    " | 13     || "Mr%20John%20Smith"
        "               "   | 5      || "%20%20%20%20%20"
    }
}