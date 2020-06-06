package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0405}单元测试
 * @date 2020/06/06 15:44
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0405Spec extends Specification {
    Lcci0405 lcci0405 = new Lcci0405()

    @Unroll
    def "isValidBST(#root) = #result"() {
        expect:
        result == this.lcci0405.isValidBST(root)

        where:
        root                                                                                   || result
        new TreeNode(
            3,
            new TreeNode(1, new TreeNode(0), new TreeNode(2)),
            new TreeNode(5, new TreeNode(4), new TreeNode(6))
        )                                                                                      || true
        new TreeNode(2, new TreeNode(1), new TreeNode(3))                                      || true
        new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))    || false
        new TreeNode(10, new TreeNode(5), new TreeNode(15, new TreeNode(6), new TreeNode(20))) || false
    }
}