package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof31}单元测试
 * @date 2020/07/04 16:04
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof31Spec extends Specification {
    Lcof31 lcof31 = new Lcof31()

    @Unroll
    def "validateStackSequences(#pushed, #poped) = #result"() {
        expect:
        result == this.lcof31.validateStackSequences(pushed, poped)

        where:
        pushed                   | poped                    || result
        [1, 2, 3, 4, 5] as int[] | [4, 5, 3, 2, 1] as int[] || true
        [1, 2, 3, 4, 5] as int[] | [4, 3, 5, 1, 2] as int[] || false
    }
}