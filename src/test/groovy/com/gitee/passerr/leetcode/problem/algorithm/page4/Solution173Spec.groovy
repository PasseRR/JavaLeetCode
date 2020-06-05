package com.gitee.passerr.leetcode.problem.algorithm.page4

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification

/**
 * {@link Solution173}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 15:32
 * @author xiehai
 */
class Solution173Spec extends Specification {
    Solution173 solution173 = new Solution173()

    def "bst iterator"() {
        given:
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)))
        BSTIterator iterator = new BSTIterator(root)

        expect:
        iterator.next() == 3
        iterator.next() == 7
        iterator.hasNext()
        iterator.next() == 9
        iterator.hasNext()
        iterator.next() == 15
        iterator.hasNext()
        iterator.next() == 20
        !iterator.hasNext()
    }
}
