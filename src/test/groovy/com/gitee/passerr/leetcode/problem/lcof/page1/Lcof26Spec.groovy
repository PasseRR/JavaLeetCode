package com.gitee.passerr.leetcode.problem.lcof.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof26}单元测试
 * @date 2020/07/04 15:49
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof26Spec extends Specification {
    Lcof26 lcof26 = new Lcof26()

    @Unroll
    def "isSubStructure(#a, #b) = #result"() {
        expect:
        result == this.lcof26.isSubStructure(a, b)

        where:
        a                                                 | b                                      || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) | new TreeNode(1, new TreeNode(2), null) || true
    }
}