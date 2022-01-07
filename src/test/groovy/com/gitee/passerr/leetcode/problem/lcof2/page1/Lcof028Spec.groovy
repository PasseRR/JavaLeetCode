package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.Node
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof028}单元测试
 * @date 2022/01/07 14:26
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof028Spec extends Specification {
    Lcof028 lcof028 = new Lcof028()

    @Unroll
    def "flatten(#head) = #result"() {
        expect:
        result == this.lcof028.flatten(head)

        where:
        head       || result
        new Node() || new Node()
    }
}
