package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1711}单元测试
 * @date 2021/05/18 10:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1711Spec extends Specification {
    Lcci1711 lcci1711 = new Lcci1711()

    @Unroll
    def "findClosest(#words, #word1, #word2) = #result"() {
        expect:
        result == this.lcci1711.findClosest(words, word1, word2)

        where:
        words                                                                                 | word1 | word2    || result
        ["I", "am", "a", "student", "from", "a", "university", "in", "a", "city"] as String[] | "a"   | "student" | 1
    }
}