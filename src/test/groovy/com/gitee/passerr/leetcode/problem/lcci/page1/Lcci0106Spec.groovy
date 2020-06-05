package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0106}单元测试
 * @date 2020/06/05 15:53
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0106Spec extends Specification {
    Lcci0106 lcci0106 = new Lcci0106()

    @Unroll
    def "compressString(#s) = #result"() {
        expect:
        result == this.lcci0106.compressString(s)

        where:
        s             || result
        "aabcccccaaa" || "a2b1c5a3"
        "abbccd"      || "abbccd"
    }
}