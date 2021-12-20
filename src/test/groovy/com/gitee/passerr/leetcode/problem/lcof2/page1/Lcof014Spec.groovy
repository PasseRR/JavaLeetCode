package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof014}单元测试
 * @date 2021/12/16 16:38
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof014Spec extends Specification {
    Lcof014 lcof014 = new Lcof014()

    @Unroll
    def "checkInclusion(#s1, #s2) = #result"() {
        expect:
        result == this.lcof014.checkInclusion(s1, s2)

        where:
        s1   | s2         || result
        "ab" | "eidboaoo" || false
        "ab" | "eidbaooo" || true
    }
}
