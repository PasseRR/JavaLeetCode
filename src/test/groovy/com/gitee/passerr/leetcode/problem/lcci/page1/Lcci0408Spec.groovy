package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0408}单元测试
 * @date 2020/06/08 17:34
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0408Spec extends Specification {
    Lcci0408 lcci0408 = new Lcci0408()

    @Unroll
    def "lowestCommonAncestor(#root, #p, #q) = #result"() {
        expect:
        result == this.lcci0408.lowestCommonAncestor(root, p, q)

        where:
        p               | q               | root                  || result
        new TreeNode(1) | new TreeNode(5) | new TreeNode(5, p, q) || root
    }
}