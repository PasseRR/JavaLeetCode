package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof034}单元测试
 * @date 2022/01/10 14:30
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof034Spec extends Specification {
    Lcof034 lcof034 = new Lcof034()

    @Unroll
    def "isAlienSorted(#words, #order) = #result"() {
        expect:
        result == this.lcof034.isAlienSorted(words, order)

        where:
        words                                | order                        || result
        ["hello", "leetcode"] as String[]    | "hlabcdefgijkmnopqrstuvwxyz" || true
        ["word", "world", "row"] as String[] | "worldabcefghijkmnpqstuvxyz" || false
        ["apple", "app"] as String[]         | "abcdefghijklmnopqrstuvwxyz" || false
    }
}
