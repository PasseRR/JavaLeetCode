package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0404}单元测试
 * @date 2020/06/06 15:40
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0404Spec extends Specification {
    Lcci0404 lcci0404 = new Lcci0404()

    @Unroll
    def "isBalanced(#root) = #result"() {
        expect:
        result == this.lcci0404.isBalanced(root)

        where:
        root                                                          || result
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
            new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))
        )                                                             || false
        null                                                          || true
        new TreeNode(1)                                               || true
        new TreeNode(1, new TreeNode(2), new TreeNode(3))             || true
        new TreeNode(1, new TreeNode(2, new TreeNode(1), null), null) || false
    }
}