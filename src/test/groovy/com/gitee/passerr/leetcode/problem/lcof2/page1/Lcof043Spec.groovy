package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification

/**
 * {@link Lcof043}单元测试
 * @date 2022/01/15 12:28
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof043Spec extends Specification {
    Lcof043 lcof043 = new Lcof043()

    def "CBTInserter"() {
        given:
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))

        def inserter = new CBTInserter(root)

        expect:
        inserter.insert(5) == 3
        inserter.insert(6) == 4
    }

    def "cbt"() {
        given:
        def root = new TreeNode(1, new TreeNode(2), null)
        def inserter = new CBTInserter(root)
        
        expect:
        inserter.insert(3) == 1
        inserter.insert(4) == 2
        inserter.get_root() == root
    }
}
