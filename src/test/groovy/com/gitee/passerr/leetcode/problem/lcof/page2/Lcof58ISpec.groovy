package com.gitee.passerr.leetcode.problem.lcof.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof58I}单元测试
 * @date 2020/07/22 08:42
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof58ISpec extends Specification {
    Lcof58I lcof58 = new Lcof58I()

    @Unroll
    def "reverseWords(#s) = #result"() {
        expect:
        result == this.lcof58.reverseWords(s)

        where:
        s                  || result
        "the sky is blue"  || "blue is sky the"
        "  hello world!  " || "world! hello"
    }
}