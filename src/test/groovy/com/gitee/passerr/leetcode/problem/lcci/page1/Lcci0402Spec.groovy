package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0402}单元测试
 * @date 2020/06/06 14:55
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0402Spec extends Specification {
    Lcci0402 lcci0402 = new Lcci0402()

    @Unroll
    def "sortedArrayToBST(#nums) = #result"() {
        expect:
        result == this.lcci0402.sortedArrayToBST(nums)

        where:
        nums                        || result
        [-10, -3, 0, 5, 9] as int[] || new TreeNode(
            0,
            new TreeNode(-10, null, new TreeNode(-3)),
            new TreeNode(5, null, new TreeNode(9))
        )
    }
}