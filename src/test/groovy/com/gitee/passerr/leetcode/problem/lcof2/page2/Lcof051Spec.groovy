package com.gitee.passerr.leetcode.problem.lcof2.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof051}单元测试
 * @date 2022/01/18 14:33
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof051Spec extends Specification {
    Lcof051 lcof051 = new Lcof051()

    @Unroll
    def "maxPathSum(#root) = #result"() {
        expect:
        result == this.lcof051.maxPathSum(root)

        where:
        root                                              || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) || 6
        new TreeNode(
            -10,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
        )                                                 || 42
    }
}
