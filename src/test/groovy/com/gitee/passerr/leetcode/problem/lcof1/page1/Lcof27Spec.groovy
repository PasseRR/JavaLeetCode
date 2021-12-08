package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof27}单元测试
 * @date 2020/07/04 15:51
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof27Spec extends Specification {
    Lcof27 lcof27 = new Lcof27()

    @Unroll
    def "mirrorTree(#root) = #result"() {
        expect:
        result == this.lcof27.mirrorTree(root)

        where:
        root                                              || result
        new TreeNode(4, new TreeNode(2), new TreeNode(7)) || new TreeNode(4, new TreeNode(7), new TreeNode(2))
    }
}