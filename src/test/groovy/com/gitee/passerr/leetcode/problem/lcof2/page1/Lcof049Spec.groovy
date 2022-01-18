package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof049}单元测试
 * @date 2022/01/17 15:45
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof049Spec extends Specification {
    Lcof049 lcof049 = new Lcof049()

    @Unroll
    def "sumNumbers(#root) = #result"() {
        expect:
        result == this.lcof049.sumNumbers(root)

        where:
        root                                              || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) || 25
    }
}
