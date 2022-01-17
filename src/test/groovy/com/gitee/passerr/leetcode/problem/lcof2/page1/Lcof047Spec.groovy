package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof047}单元测试
 * @date 2022/01/17 11:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof047Spec extends Specification {
    Lcof047 lcof047 = new Lcof047()

    @Unroll
    def "pruneTree(#root) = #result"() {
        expect:
        result == this.lcof047.pruneTree(root)

        where:
        root || result
        new TreeNode(
            1,
            null,
            new TreeNode(0, new TreeNode(0), new TreeNode(1))
        )    || new TreeNode(
            1,
            null,
            new TreeNode(0, null, new TreeNode(1))
        )
    }
}
