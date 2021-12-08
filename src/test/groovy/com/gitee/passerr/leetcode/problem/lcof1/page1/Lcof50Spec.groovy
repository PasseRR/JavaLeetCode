package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof50}单元测试
 * @date 2020/07/14 13:19
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof50Spec extends Specification {
    Lcof50 lcof50 = new Lcof50()

    @Unroll
    def "firstUniqChar(#s) = #result"() {
        expect:
        result == this.lcof50.firstUniqChar(s)

        where:
        s           || result
        ""          || " " as char
        "abaccdeff" || "b" as char
    }
}