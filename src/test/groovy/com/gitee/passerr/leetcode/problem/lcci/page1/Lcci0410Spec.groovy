package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0410}单元测试
 * @date 2020/06/23 09:22
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0410Spec extends Specification {
    Lcci0410 lcci0410 = new Lcci0410()

    @Unroll
    def "checkSubTree(#t1, #t2) = #result"() {
        expect:
        result == this.lcci0410.checkSubTree(t1, t2)

        where:
        t1                                                | t2                                     || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) | new TreeNode(2)                        || true
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) | new TreeNode(2, new TreeNode(1), null) || false
    }
}