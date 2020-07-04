package com.gitee.passerr.leetcode.problem.lcof.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof07}单元测试
 * @date 2020/07/04 14:33
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof07Spec extends Specification {
    Lcof07 lcof07 = new Lcof07()

    @Unroll
    def "buildTree(#preorder, #inorder) = #result"() {
        expect:
        result == this.lcof07.buildTree(preorder, inorder)

        where:
        preorder                   | inorder                    || result
        [3, 9, 20, 15, 7] as int[] | [9, 3, 15, 20, 7] as int[] || new TreeNode(
            3,
            new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))
        )
    }
}