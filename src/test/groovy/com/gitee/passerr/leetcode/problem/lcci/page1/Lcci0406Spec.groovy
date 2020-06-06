package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0406}单元测试
 * @date 2020/06/06 17:35
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0406Spec extends Specification {
    Lcci0406 lcci0406 = new Lcci0406()

    @Unroll
    def "inorderSuccessor(#root, #p) = #result"() {
        expect:
        result == this.lcci0406.inorderSuccessor(root, p)

        where:
        root                                              | p               || result
        new TreeNode(2, new TreeNode(1), new TreeNode(3)) | new TreeNode(2) || new TreeNode(3)
        new TreeNode(2, new TreeNode(1), new TreeNode(3)) | new TreeNode(3) || null
        new TreeNode(2, new TreeNode(1), new TreeNode(3)) | new TreeNode(1) || new TreeNode(
            2, new TreeNode(1), new TreeNode(3)
        )
    }
}