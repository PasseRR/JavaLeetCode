package com.gitee.passerr.leetcode.problem.lcof.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof32III}单元测试
 * @date 2020/07/04 16:18
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof32IIISpec extends Specification {
    Lcof32III lcof32III = new Lcof32III()

    @Unroll
    def "levelOrder(#root) = #result"() {
        expect:
        result == this.lcof32III.levelOrder(root)

        where:
        root                                                                     || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3))                        || [[1], [3, 2]]
        new TreeNode(1, new TreeNode(3, new TreeNode(1), new TreeNode(2)), null) || [[1], [3], [1, 2]]
    }
}