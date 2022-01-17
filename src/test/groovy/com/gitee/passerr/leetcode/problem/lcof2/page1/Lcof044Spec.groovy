package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof044}单元测试
 * @date 2022/01/17 10:51
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof044Spec extends Specification {
    Lcof044 lcof044 = new Lcof044()

    @Unroll
    def "largestValues(#root) = #result"() {
        expect:
        result == this.lcof044.largestValues(root)

        where:
        root                                              || result
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9))
        )                                                 || [1, 3, 9]
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) || [1, 3]
        new TreeNode(1)                                   || [1]
        null                                              || []
    }
}
