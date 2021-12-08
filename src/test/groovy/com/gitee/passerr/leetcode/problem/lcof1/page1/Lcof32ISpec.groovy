package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof32I}单元测试
 * @date 2020/07/04 16:08
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof32ISpec extends Specification {
    Lcof32I lcof32I = new Lcof32I()

    @Unroll
    def "levelOrder(#root) = #result"() {
        expect:
        result == this.lcof32I.levelOrder(root)

        where:
        root                                                                     || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3))                        || [1, 2, 3] as int[]
        new TreeNode(1, new TreeNode(3, new TreeNode(1), new TreeNode(2)), null) || [1, 3, 1, 2] as int[]
    }
}