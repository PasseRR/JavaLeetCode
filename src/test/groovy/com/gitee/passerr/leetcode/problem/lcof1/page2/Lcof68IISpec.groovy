package com.gitee.passerr.leetcode.problem.lcof1.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof68II}单元测试
 * @date 2020/07/22 09:44
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof68IISpec extends Specification {
    Lcof68II lcof68II = new Lcof68II()

    @Unroll
    def "lowestCommonAncestor(#root, #p, #q) = #result"() {
        expect:
        result == this.lcof68II.lowestCommonAncestor(root, p, q)

        where:
        p               | q                                   | root                                || result
        new TreeNode(2) | new TreeNode(3, p, new TreeNode(4)) | new TreeNode(5, q, new TreeNode(6)) || q
    }
}