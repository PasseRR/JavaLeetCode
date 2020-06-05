package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0104}单元测试
 * @date 2020/06/05 15:47
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0104Spec extends Specification {
    Lcci0104 lcci0104 = new Lcci0104()

    @Unroll
    def "canPermutePalindrome(#s) = #result"() {
        expect:
        result == this.lcci0104.canPermutePalindrome(s)

        where:
        s         || result
        "tactcoa" || true
        "aaab"    || false
    }
}