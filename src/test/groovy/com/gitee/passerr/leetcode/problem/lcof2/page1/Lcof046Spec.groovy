package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof046}单元测试
 * @date 2022/01/17 11:32
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof046Spec extends Specification {
    Lcof046 lcof046 = new Lcof046()

    @Unroll
    def "rightSideView(#root) = #result"() {
        expect:
        result == this.lcof046.rightSideView(root)

        where:
        root                                              || result
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9))
        )                                                 || [1, 2, 9]
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) || [1, 3]
        new TreeNode(1)                                   || [1]
        null                                              || []
    }
}
