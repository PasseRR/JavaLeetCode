package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof050}单元测试
 * @date 2022/01/17 16:15
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof050Spec extends Specification {
    Lcof050 lcof050 = new Lcof050()

    @Unroll
    def "pathSum(#root, #targetSum) = #result"() {
        expect:
        result == this.lcof050.pathSum(root, targetSum)

        where:
        root | targetSum || result
        new TreeNode(
            10,
            new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
            new TreeNode(-3, null, new TreeNode(11))
        )    | 8         || 3
    }
}
