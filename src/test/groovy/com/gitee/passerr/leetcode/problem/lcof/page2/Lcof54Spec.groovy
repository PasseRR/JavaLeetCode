package com.gitee.passerr.leetcode.problem.lcof.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof54}单元测试
 * @date 2020/07/14 16:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof54Spec extends Specification {
    Lcof54 lcof54 = new Lcof54()

    @Unroll
    def "kthLargest(#root, #k) = #result"() {
        expect:
        result == this.lcof54.kthLargest(root, k)

        where:
        root | k || result
        new TreeNode(
            3,
            new TreeNode(1, null, new TreeNode(2)),
            new TreeNode(4)
        )    | 1 || 4
        new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
            new TreeNode(6)
        )    | 3 || 4
    }
}