package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0412}单元测试
 * @date 2020/06/23 09:26
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0412Spec extends Specification {
    Lcci0412 lcci0412 = new Lcci0412()

    @Unroll
    def "pathSum(#root, #sum) = #result"() {
        expect:
        result == this.lcci0412.pathSum(root, sum)

        where:
        root                                                                      | sum || result
        new TreeNode(1, new TreeNode(-1, new TreeNode(0), null), new TreeNode(0)) | 0   || 4
    }
}