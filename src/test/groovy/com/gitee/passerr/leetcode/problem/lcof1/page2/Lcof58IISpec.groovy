package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof58II}单元测试
 * @date 2020/07/22 08:47
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof58IISpec extends Specification {
    Lcof58II lcof58II = new Lcof58II()

    @Unroll
    def "reverseLeftWords(#s, #n) = #result"() {
        expect:
        result == this.lcof58II.reverseLeftWords(s, n)

        where:
        s            | n || result
        "abcdefg"    | 2 || "cdefgab"
        "lrloseumgh" | 6 || "umghlrlose"
    }
}