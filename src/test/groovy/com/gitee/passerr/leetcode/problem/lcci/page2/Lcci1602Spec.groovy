package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification

/**
 * {@link Lcci1602}单元测试
 * @date 2020/08/10 16:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1602Spec extends Specification {
    Lcci1602 lcci1602 = new Lcci1602()

    def "WordsFrequency"() {
        given:
        WordsFrequency frequency = new WordsFrequency(["i", "have", "an", "apple", "he", "have", "a", "pen"] as String[])

        expect:
        result == frequency.get(word)

        where:
        word   || result
        "i"    || 1
        "have" || 2
        "see"  || 0
    }
}