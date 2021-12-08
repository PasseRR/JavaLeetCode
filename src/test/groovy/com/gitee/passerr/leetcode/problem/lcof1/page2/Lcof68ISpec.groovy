package com.gitee.passerr.leetcode.problem.lcof1.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof68I}单元测试
 * @date 2020/07/22 09:39
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof68ISpec extends Specification {
    Lcof68I lcof68I = new Lcof68I()

    @Unroll
    def "lowestCommonAncestor(#root, #p, #q) = #result"() {
        expect:
        result == this.lcof68I.lowestCommonAncestor(root, p, q)

        where:
        root | p               | q               || result
        new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6)
        )    | new TreeNode(3) | new TreeNode(2) || root.left
    }
}