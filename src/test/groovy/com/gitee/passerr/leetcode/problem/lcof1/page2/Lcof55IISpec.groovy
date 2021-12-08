package com.gitee.passerr.leetcode.problem.lcof1.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof55II}单元测试
 * @date 2020/07/14 16:29
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof55IISpec extends Specification {
    Lcof55II lcof55II = new Lcof55II()

    @Unroll
    def "isBalanced(#root) == #result"() {
        expect:
        result == this.lcof55II.isBalanced(root)

        where:
        root                                                                                  || result
        new TreeNode(3, new TreeNode(3), new TreeNode(20, new TreeNode(15), new TreeNode(7))) || true
        new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null)                         || false
    }
}