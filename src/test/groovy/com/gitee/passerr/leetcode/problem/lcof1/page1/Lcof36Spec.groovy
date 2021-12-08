package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.Node
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof36}单元测试
 * @date 2020/07/14 12:44
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof36Spec extends Specification {
    Lcof36 lcof36 = new Lcof36()

    @Unroll
    def "treeToDoublyList(#root) = #result"() {
        expect:
        result == this.lcof36.treeToDoublyList(root)
        where:
        root                          || result
        new Node(1, null, null, null) || root
    }
}