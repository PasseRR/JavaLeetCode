package com.gitee.passerr.leetcode.problem.lcof.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof55I}单元测试
 * @date 2020/07/14 16:26
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof55ISpec extends Specification {
    Lcof55I lcof55I = new Lcof55I()

    @Unroll
    def "maxDepth(#root) = #result"() {
        expect:
        result == this.lcof55I.maxDepth(root)

        where:
        root                                                                                  || result
        new TreeNode(3, new TreeNode(3), new TreeNode(20, new TreeNode(15), new TreeNode(7))) || 3
    }
}