package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof045}单元测试
 * @date 2022/01/17 11:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof045Spec extends Specification {
    Lcof045 lcof045 = new Lcof045()

    @Unroll
    def "findBottomLeftValue(#root) = #result"() {
        expect:
        result == this.lcof045.findBottomLeftValue(root)

        where:
        root                                              || result
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9))
        )                                                 || 5
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) || 2
        new TreeNode(1)                                   || 1
    }
}
