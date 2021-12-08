package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification

/**
 * {@link Lcof37}单元测试
 * @date 2020/07/14 12:48
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof37Spec extends Specification {
    def "codec"() {
        given:
        def tree = new TreeNode(1, new TreeNode(2), new TreeNode(3))
        def codec = new Codec()
        expect:
        codec.deserialize(codec.serialize(tree)) == tree
    }
}