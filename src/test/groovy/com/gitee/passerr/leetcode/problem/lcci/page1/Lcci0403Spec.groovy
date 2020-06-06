package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0403}单元测试
 * @date 2020/06/06 15:34
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0403Spec extends Specification {
    Lcci0403 lcci0403 = new Lcci0403()

    @Unroll
    def "listOfDepth(#tree) == #result"() {
        expect:
        result == this.lcci0403.listOfDepth(tree)

        where:
        tree || result
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5)),
            new TreeNode(3, null, new TreeNode(7))
        )    || [
            ListNode.of(1),
            ListNode.of(2, 3),
            ListNode.of(4, 5, 7),
            ListNode.of(8)
        ] as ListNode[]
    }
}