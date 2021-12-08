package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof28}单元测试
 * @date 2020/07/04 15:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof28Spec extends Specification {
    Lcof28 lcof28 = new Lcof28()

    @Unroll
    def "isSymmetric(#root) == #result"() {
        expect:
        result == this.lcof28.isSymmetric(root)

        where:
        root                                              || result
        new TreeNode(1)                                   || true
        new TreeNode(1, new TreeNode(2), new TreeNode(2)) || true
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) || false
    }
}