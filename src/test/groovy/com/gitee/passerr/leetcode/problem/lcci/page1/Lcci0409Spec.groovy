package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0409}单元测试
 * @date 2020/06/08 18:02
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0409Spec extends Specification {
    Lcci0409 lcci0409 = new Lcci0409()

    @Unroll
    def "BSTSequences(#root) == #result"() {
        expect:
        result == this.lcci0409.BSTSequences(root)

        where:
        root                                              || result
        new TreeNode(2, new TreeNode(1), new TreeNode(3)) || [[2, 1, 3], [2, 3, 1]]
        new TreeNode(
            3,
            new TreeNode(2, new TreeNode(1), null),
            new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))
        )                                                 || [
            [3, 2, 4, 1, 5, 6],
            [3, 2, 4, 5, 1, 6],
            [3, 2, 4, 5, 6, 1],
            [3, 2, 1, 4, 5, 6],
            [3, 4, 2, 5, 1, 6],
            [3, 4, 2, 5, 6, 1],
            [3, 4, 2, 1, 5, 6],
            [3, 4, 5, 2, 6, 1],
            [3, 4, 5, 2, 1, 6],
            [3, 4, 5, 6, 2, 1]
        ]
    }
}