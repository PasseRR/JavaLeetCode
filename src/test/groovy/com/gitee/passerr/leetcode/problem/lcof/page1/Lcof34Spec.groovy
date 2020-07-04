package com.gitee.passerr.leetcode.problem.lcof.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof34}单元测试
 * @date 2020/07/04 16:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof34Spec extends Specification {
    Lcof34 lcof34 = new Lcof34()

    @Unroll
    def "pathSum(#root, #sum) = #result"() {
        expect:
        result == this.lcof34.pathSum(root, sum)

        where:
        root                                              | sum || result
        new TreeNode(1, new TreeNode(2), new TreeNode(2)) | 3   || [[1, 2], [1, 2]]
    }
}